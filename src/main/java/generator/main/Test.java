package generator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import generator.util.Archive;

public class Test {
	
	
	public static boolean isValidPath(String path) {
	    try {
	        Paths.get(path);
	    } catch (InvalidPathException | NullPointerException ex) {
	        return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		String path=null;
		System.out.println(isValidPath(path));
//	        try {
//
//	            Process process = processBuilder.start();
//
//	            System.out.println("process ping...");
//	            ProcessReadTask task = new ProcessReadTask(process.getInputStream());
//	            Future<List<String>> future = pool.submit(task);
//
//	            // no block, can do other tasks here
//	            System.out.println("process task1...");
//	            System.out.println("process task2...");
//
//	            List<String> result = future.get(5, TimeUnit.SECONDS);
//	            for (String s : result) {
//	                System.out.println(s);
//	            }
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        } finally {
//	            pool.shutdown();
//	        }

	}
	
//	private static class ProcessReadTask implements Callable<List<String>> {
//
//        private InputStream inputStream;
//
//        public ProcessReadTask(InputStream inputStream) {
//            this.inputStream = inputStream;
//        }
//
//        @Override
//        public List<String> call() {
//            return new BufferedReader(new InputStreamReader(inputStream))
//				.lines()
//				.collect(Collectors.toList());
//        }
//    }

}
