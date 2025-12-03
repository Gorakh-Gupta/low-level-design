package com.gorakh.lldrunner;
import com.gorakh.lldrunner.tictactoegame.TictactoeSystemDemo;
import com.gorakh.lldrunner.stockbrokeragesystem.StockBrokerageSystemDemo;
import com.gorakh.lldrunner.musicstreamingservice.MusicStreamingServiceDemo;

public class LldrunnerApplication {

	public static void main(String[] args) {
		TictactoeSystemDemo.run();
		StockBrokerageSystemDemo.run();
		MusicStreamingServiceDemo.run();
	}

}
