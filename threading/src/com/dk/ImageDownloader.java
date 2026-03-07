package com.dk;

import java.util.ArrayList;
import java.util.List;

class Downloader extends Thread {
	String image;

	public Downloader(String image) {
		super();
		this.image = image;
	}

	public void run() {
		System.out.println("Thread started");
		this.download(image);
	}

	public void download(String image) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("downloading " + image);
	}
}

public class ImageDownloader {

	public static void main(String[] args) throws InterruptedException {
		String images[] = { "image1", "image2", "image3" };
		List<Thread> list = new ArrayList<>();
		for (int i = 0; i < images.length; i++) {
			Downloader loader = new Downloader(images[i]);
			list.add(loader);
			loader.start();
		}
		for (Thread t : list) {
			t.join(); // let it finish main will wait till loader thread finishes
		}

		System.out.println("All images downloaded");
	}

}
