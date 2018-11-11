package com.madhusudhan.wr.allaboutlambdas.introduction;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.madhusudhan.wr.allaboutlambdas.domain.Movie;
import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.MovieUtil;

/**
 * This class defines few lambda expressions.
 * @author mkonda
 *
 */
public class Examples {

	/**
	 *  A callable lambda
	 */
	
	Callable<Trade> c = () -> {
		Trade t = new Trade("GOOGLE", 2000, "OPEN");
		encrypt(t);
		persist(t);
		return t;
	};

	/**
	 * fetching movies directed by a specific director
	 * 
	 * @param movies
	 * @param director
	 */
	private void fetchMovies(List<Movie> movies, String director) {
		movies
		  .stream()
		  .filter(m -> m.getDirector().equals(director))
		  .map(Movie::getName)
		  .distinct()
		  .forEach(System.out::println);
	}

	public void testCallable() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Trade> future = executor.submit(c);
		System.out.println("     "+future.get());
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		List<Movie> movies = MovieUtil.createMovies();
		new Examples().fetchMovies(movies, "Steven Spielberg");
		new Examples().testCallable();
		 
	}

	private void persist(Trade t) {
		System.out.println("Persisting the trade ..");
	}

	private void encrypt(Trade t) {
		System.out.println("Encrypting the trade..");
	}

}
