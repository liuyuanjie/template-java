package org.oobootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParkingManagerTests {
    @Test
    void should_park_by_parking_boy_G_and_return_ticket_when_pack_given_parking_manager_M_has_graduate_boy_G_and_smart_boy_S_and_G_has_parkingLots_G1_G2_and_all_G1_G2_capacity_are_3_and_G1_has_1_car_and_G2_has_0_car_and_S_has_parkingLots_S1_S2_and_all_S1_S2_capacity_are_3_and_both_have_0_car_and_M_has_parkingLots_M1_and_capacity_are_3_and_has_1_car() throws Exception {
        // Arrange
        ParkingLot parkingLotG1 = new ParkingLot(3);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(3);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(3);
        ParkingLot parkingLotS2 = new ParkingLot(3);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(3);
        parkingLotM1.park(new Car());
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        Car car = new Car();

        //Act
        Ticket ticket = parkingManager.park(car);

        //Assert
        Assertions.assertEquals(car, parkingBoyG.pick(ticket));
    }

    @Test
    void should_park_by_parking_boy_S_and_return_ticket_when_pack_given_parking_manager_M_has_graduate_boy_G_and_smart_boy_S_and_G_has_parkingLots_G1_G2_and_all_G1_G2_capacity_are_1_and_both_has_1_car_and_S_has_parkingLots_S1_S2_and_all_S1_S2_capacity_are_3_and_S1_has_1_car_and_S2_has_0_car_and_M_has_parkingLots_M1_and_capacity_are_3_and_has_1_car() throws Exception {
        // Arrange
        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        parkingLotG2.park(new Car());
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(3);
        parkingLotS1.park(new Car());
        ParkingLot parkingLotS2 = new ParkingLot(3);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(3);
        parkingLotM1.park(new Car());
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        Car car = new Car();

        //Act
        Ticket ticket = parkingManager.park(car);

        //Assert
        Assertions.assertEquals(car, parkingBoyS.pick(ticket));
    }

    @Test
    void should_park_by_parking_manager_M_and_return_ticket_when_pack_given_parking_manager_M_has_graduate_boy_G_and_smart_boy_S_and_G_has_parkingLots_G1_G2_and_all_G1_G2_capacity_are_1_and_both_have_1_car_and_S_has_parkingLots_S1_S2_and_all_S1_S2_capacity_are_1_and_both_have_1_car_and_M_has_parkingLots_M1_and_capacity_are_3_and_has_1_car() throws Exception {
        // Arrange
        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        parkingLotG2.park(new Car());
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        parkingLotS1.park(new Car());
        ParkingLot parkingLotS2 = new ParkingLot(1);
        parkingLotS2.park(new Car());
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(3);
        parkingLotM1.park(new Car());
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        Car car = new Car();

        //Act
        Ticket ticket = parkingManager.park(car);

        //Assert
        Assertions.assertEquals(car, parkingLotM1.pick(ticket));
    }


    @Test
    void should_park_by_parking_manager_M_and_return_ticket_when_pack_given_parking_manager_M_has_graduate_boy_G_and_smart_boy_S_and_G_has_parkingLots_G1_G2_and_all_G1_G2_capacity_are_1_and_both_have_1_car_and_S_has_parkingLots_S1_S2_and_all_S1_S2_capacity_are_1_and_both_have_1_car_and_M_has_parkingLots_M1_M2_and_both_capacity_are_1_and_M1_has_1_car_and_M2_has_0_car() throws Exception {
        // Arrange
        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        parkingLotG2.park(new Car());
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        parkingLotS1.park(new Car());
        ParkingLot parkingLotS2 = new ParkingLot(1);
        parkingLotS2.park(new Car());
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        parkingLotM1.park(new Car());
        ParkingLot parkingLotM2 = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1, parkingLotM2));

        Car car = new Car();

        //Act
        Ticket ticket = parkingManager.park(car);

        //Assert
        Assertions.assertEquals(car, parkingLotM2.pick(ticket));
    }
}
