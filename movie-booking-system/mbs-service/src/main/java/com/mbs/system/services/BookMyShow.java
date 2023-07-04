package com.mbs.system.services;
import com.mbs.system.domain.*;
import com.mbs.system.domain.service.MovieService;
import com.mbs.system.domain.service.TheatreService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class BookMyShow {

    private MovieService movieController;
    private TheatreService theatreController;




    public static void main(String args[]) {

        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();


        City banglore=new City();
        banglore.setName("Banglore");
        banglore.setCityId(1L);

        //user1
        bookMyShow.createBooking(banglore, "ADHIPURUSH");
        //user2
        bookMyShow.createBooking(banglore, "BAAHUBALI");

    }

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see.
        Movie interestedMovie = movies.stream()
                .filter(movie -> movie.getTitle().equals(movieName))
                .findFirst()
                .orElse(null);


        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        Integer seatNumber = 30;
        Set<Integer> finalBookedSeat=new HashSet<>();
        List<Booking> bookingList=interestedShow.getBookingList();
        List<List<Integer>> bookedSeatsList = bookingList.stream()
                .map(Booking::getBookedSeats)
                .map(seats -> seats.stream().map(Show_Seat::getShowSeatId).collect(Collectors.toList()))
                .collect(Collectors.toList());

        bookedSeatsList.stream().forEach(finalBookedSeat::addAll);

        /*List<Long> bookedSeats = interestedShow.getBookingList().stream().
                flatMap(booking -> booking.getBookedSeats()).*/
        if (!finalBookedSeat.contains(seatNumber)) {
            finalBookedSeat.add(seatNumber);
            // startPayment
            Booking booking = new Booking();
            List<ScreenSeat> myBookedSeats = interestedShow.getScreen().getSeats().stream()
                    .filter(screenSeat -> screenSeat.getSeatNumber() == seatNumber)
                    .collect(Collectors.toList());

            booking.setBookedSeats(myBookedSeats.stream().map(ScreenSeat::getShowSeatList).collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList()));
            booking.setShow(interestedShow);
        } else {
            // throw exception
            System.out.println("Seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    //creating 2 theatre
    private void createTheatre() {

        City banglore=new City();
        banglore.setName("Banglore");
        banglore.setCityId(1L);

        City delhi=new City();
        banglore.setName("Delhi");
        banglore.setCityId(2L);

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(banglore);
        List<Show> inoxShows = new ArrayList<>();
        List<Show_Seat> showSeatList=createSeats();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreen().get(0), avengerMovie, LocalDateTime.of(2023,07,03,18,0,0),LocalDateTime.of(2023,07,03,18,0,0),showSeatList);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreen().get(0), baahubali, LocalDateTime.of(2023,07,03,18,0,0),LocalDateTime.of(2023,07,03,18,0,0),showSeatList);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreen().get(0), avengerMovie, LocalDateTime.of(2023,07,03,18,0,0),LocalDateTime.of(2023,07,03,18,0,0),showSeatList);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreen().get(0), baahubali,LocalDateTime.of(2023,07,03,18,0,0),LocalDateTime.of(2023,07,03,18,0,0),showSeatList);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);


        theatreController.add(inoxTheatre, banglore);
        theatreController.add(pvrTheatre, delhi);

    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        List<ScreenSeat> screenSeats=new ArrayList<>();
        screenSeats.stream().forEach(screenSeat -> screenSeat.setShowSeatList(createSeats()));
        screen1.setSeats(screenSeats);
        screens.add(screen1);

        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie,LocalDateTime showStartTime,LocalDateTime showEndTime,List<Show_Seat> showSeatList) {

        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowSeatList(showSeatList);
        show.setStartTime(showStartTime);
        show.setEndTime(showEndTime);
        show.setEndTime(LocalDateTime.of(2023,07,03,21,0,0));
        return show;
    }

    //creating 100 seats
    private List<Show_Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Show_Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Show_Seat seat = new Show_Seat();
            seat.setShowSeatId(i);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Show_Seat seat = new Show_Seat();
            seat.setShowSeatId(i);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Show_Seat seat = new Show_Seat();
            seat.setShowSeatId(i);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setTitle("AVENGERS");
        avengers.setMovieDurationInMinutes(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setTitle("BAAHUBALI");
        baahubali.setMovieDurationInMinutes(180);


        City banglore=new City();
        banglore.setName("Banglore");
        banglore.setCityId(1L);

        City delhi=new City();
        banglore.setName("Delhi");
        banglore.setCityId(2L);
        //add movies against the cities
        movieController.add(avengers, banglore);
        movieController.add(avengers, delhi);
        movieController.add(baahubali, banglore);
        movieController.add(baahubali, delhi);
    }
}
