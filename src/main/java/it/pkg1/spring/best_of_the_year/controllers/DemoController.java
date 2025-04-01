package it.pkg1.spring.best_of_the_year.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pkg1.spring.best_of_the_year.models.Movie;
import it.pkg1.spring.best_of_the_year.models.Song;

@Controller
@RequestMapping("/")
public class DemoController {

    Movie film1 = new Movie(1, "La Compagnia Dell'Anello");
    Movie film2 = new Movie(2, "Le Due Torri");
    Movie film3 = new Movie(3, "Il Ritorno Del Re");
    Movie film4 = new Movie(4, "Il Cacciatore");
    Movie film5 = new Movie(5, "The Warriors");

    List<Movie> getBestMovies = Arrays.asList(film1, film2, film3, film4, film5);

    Song song1 = new Song(1, "To Love Somebody");
    Song song2 = new Song(2, "Fire");
    Song song3 = new Song(3, "Echoes");
    Song song4 = new Song(4, "White Room");
    Song song5 = new Song(5, "Whole Lotta Love");

    List<Song> getBestSongs = Arrays.asList(song1, song2, song3, song4, song5);

    @GetMapping("/demo")
    public String greeting(Model model, 
    @RequestParam(name = "name") String name) {
    model.addAttribute("name", name);
    return "demo";
    }

   @GetMapping("/movies")
   public String movies(Model model) {
    model.addAttribute("listFilm", getBestMovies);
    return "movies";
   }

   @GetMapping("/songs")
   public String songs(Model model) { 
    model.addAttribute("listSongs", getBestSongs);
    return "songs";
   }

   @GetMapping("/movieID")
   public String movieID(@RequestParam(name = "id") int id, Model model){
        for(Movie movie_id :getBestMovies){
            if(movie_id.getId() == id){
                model.addAttribute("movieId", movie_id);
                break;
            }
        }
        return "searchMovie";
   }

   @GetMapping("/songID")
    public String songID(@RequestParam(name = "id") int id, Model model){
        for(Song song_id :getBestSongs){
            if(song_id.getId() == id){
                model.addAttribute("songId", song_id);
                break;
            }
        }
        return "searchSong";
   }

   @GetMapping("/movieList")
    public String movieList(Model model) {
    model.addAttribute("listFilm", getBestMovies);
    return "movieList";
    }
 
    @GetMapping("/songList")
    public String songList(Model model) {
    model.addAttribute("listSongs", getBestSongs);
    return "songList";
    }

    @GetMapping("/home")
    public String home(Model model) {
    return "home";
    }
}
