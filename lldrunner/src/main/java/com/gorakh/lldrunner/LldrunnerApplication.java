package com.gorakh.lldrunner;
import com.gorakh.lldrunner.tictactoegame.TictactoeSystemDemo;
import com.gorakh.lldrunner.stockbrokeragesystem.StockBrokerageSystemDemo;
import com.gorakh.lldrunner.musicstreamingservice.MusicStreamingServiceDemo;
import com.gorakh.lldrunner.fooddeliveryservice.FoodDeliveryServiceDemo;
import com.gorakh.lldrunner.chessgame.ChessGameDemo;
import com.gorakh.lldrunner.lru.LRUCacheDemo;
import com.gorakh.lldrunner.snakeandladdergame.SnakeAndLadderDemo;
import com.gorakh.lldrunner.vendingmachine.VendingMachineDemo;
import com.gorakh.lldrunner.elevatorsystem.ElevatorSystemDemo;
import com.gorakh.lldrunner.parkinglot.ParkingLotDemo;
import com.gorakh.lldrunner.splitwise.SplitwiseServiceDemo;
import com.gorakh.lldrunner.digitalwallet.DigitalWalletDemo;
import com.gorakh.lldrunner.carrentalservice.CarrentalServiceDemo;
import com.gorakh.lldrunner.atm.AtmDemo;
import com.gorakh.lldrunner.bookmyshow.BookMyShowDemo;
import com.gorakh.lldrunner.ridesharingservice.RideSharingServiceDemo;
import com.gorakh.lldrunner.loggingframework.LogDemo;
import com.gorakh.lldrunner.distributedtaskscheduler.DistributedTaskSchedulerDemo;
public class LldrunnerApplication {
    public static void main(String[] args) throws InterruptedException {
		TictactoeSystemDemo.run();
		StockBrokerageSystemDemo.run();
		MusicStreamingServiceDemo.run();
		FoodDeliveryServiceDemo.run();
		ChessGameDemo.run();
		LRUCacheDemo.run();
		SnakeAndLadderDemo.run();
		VendingMachineDemo.run();
		ElevatorSystemDemo.run();
		ParkingLotDemo.run();
		SplitwiseServiceDemo.run();
		DigitalWalletDemo.run();
		CarrentalServiceDemo.run();
		AtmDemo.run();
		BookMyShowDemo.run();
		RideSharingServiceDemo.run();
        LogDemo.run();
        DistributedTaskSchedulerDemo.run();
    }
}
