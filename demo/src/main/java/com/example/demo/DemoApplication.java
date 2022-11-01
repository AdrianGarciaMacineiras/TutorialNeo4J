package com.example.demo;

import com.example.demo.Interface.ReleaseRepository;
import com.example.demo.Interface.SongRepository;
import com.example.demo.Relationships.AppearsOn;
import com.example.demo.Relationships.AppearsOnReverse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication implements CommandLineRunner {

	private final SongRepository songRepository;
	private final ReleaseRepository releaseRepository;

	public DemoApplication(SongRepository songRepository, ReleaseRepository releaseRepository) {
		this.songRepository = songRepository;
		this.releaseRepository = releaseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		songRepository.findAll().subscribe(song ->
		{
			System.out.println(song.getName());
			for (AppearsOn appearsOn : song.getReleases()) {
				System.out.println("	" + appearsOn.getSongNr() + " " + appearsOn.getRelease().getName());
			}
		}
		);
		/*releaseRepository.findAll().subscribe(release -> {
			System.out.println(release.getName());
			for (AppearsOnReverse appearsOnReverse : release.getAppearsOnReverses()) {
				System.out.println("	" + appearsOnReverse.getSongNr() + " " + appearsOnReverse.getSong().getName());
			}
		}
		);*/
	}
}

