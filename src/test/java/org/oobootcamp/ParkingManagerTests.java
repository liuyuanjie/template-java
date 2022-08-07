package org.oobootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.oobootcamp.Exception.InvalidTicketPickingFailException;
import org.oobootcamp.Exception.ParkingLotIsFullParkingFailException;

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

    @Test
    void should_park_fail_and_return_return_message_when_pack_given_parking_manager_M_has_graduate_boy_G_and_smart_boy_S_and_G_has_parkingLots_G1_G2_and_all_G1_G2_capacity_are_1_and_both_have_1_car_and_S_has_parkingLots_S1_S2_and_all_S1_S2_capacity_are_1_and_both_have_1_car_and_M_has_parkingLots_M1_and_capacity_is_1_and_have_0_car() throws Exception {
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
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        Car car = new Car();

        //Assert
        Assertions.assertThrows(ParkingLotIsFullParkingFailException.class, () -> parkingManager.park(car));
    }

    @Test
    void should_pick_success_when_pick_given_parking_manager_M_use_valid_ticket_of_parking_bay_G_and_car_in_parkingLot_G2() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        ParkingLot parkingLotG2 = new ParkingLot(1);
        Ticket ticket = parkingLotG2.park(car);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        parkingLotM1.park(new Car());
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        //Assert
        Assertions.assertEquals(car, parkingManager.pick(ticket));
    }

    @Test
    void should_pick_success_when_pick_given_parking_manager_M_use_valid_ticket_of_parking_bay_S_and_car_in_parkingLot_S2() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        ParkingLot parkingLotG2 = new ParkingLot(1);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        Ticket ticket = parkingLotS2.park(car);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        parkingLotM1.park(new Car());
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        // Act
        Car pickedCar = parkingManager.pick(ticket);

        //Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_pick_success_when_pick_given_parking_manager_M_use_valid_ticket_of_parkingLot_M1_and_car_in_parkingLot_M1() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        Ticket ticket = parkingLotM1.park(car);
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1));

        // Act
        Car pickedCar = parkingManager.pick(ticket);

        //Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_pick_success_when_pick_given_parking_manager_M_use_valid_ticket_of_parkingLot_M2_and_car_in_parkingLot_M2() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        ParkingLot parkingLotM2 = new ParkingLot(1);
        Ticket ticket = parkingLotM2.park(car);
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1, parkingLotM2));

        // Act
        Car pickedCar = parkingManager.pick(ticket);

        //Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_pick_fail_and_return_invalid_ticket_when_pick_given_parking_manager_M_use_invalid_ticket() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        ParkingLot parkingLotM2 = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1, parkingLotM2));

        ParkingLot parkingLotH1 = new ParkingLot(1);
        Ticket ticket = parkingLotH1.park(new Car());

        //Assert
        Assertions.assertThrows(InvalidTicketPickingFailException.class, () -> parkingManager.pick(ticket));
    }

    @Test
    void should_pick_fail_and_return_invalid_ticket_when_pick_given_parking_manager_use_one_ticket_of_self_parkingLot_and_has_been_used() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));

        ParkingLot parkingLotM1 = new ParkingLot(1);
        Ticket ticket = parkingLotM1.park(car);
        ParkingLot parkingLotM2 = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1, parkingLotM2));
        parkingManager.pick(ticket);

        //Assert
        Assertions.assertThrows(InvalidTicketPickingFailException.class, () -> parkingManager.pick(ticket));
    }

    @Test
    void should_pick_fail_and_return_invalid_ticket_when_pick_given_parking_manager_use_one_ticket_of_parkingLot_of_parking_boy_and_has_been_used() throws Exception {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotG1 = new ParkingLot(1);
        parkingLotG1.park(new Car());
        ParkingLot parkingLotG2 = new ParkingLot(1);
        ParkingBoy parkingBoyG = new GraduateParkingBoy(List.of(parkingLotG1, parkingLotG2));

        ParkingLot parkingLotS1 = new ParkingLot(1);
        ParkingLot parkingLotS2 = new ParkingLot(1);
        ParkingBoy parkingBoyS = new SmartParkingBoy(List.of(parkingLotS1, parkingLotS2));
        Ticket ticket = parkingBoyS.park(car);

        ParkingLot parkingLotM1 = new ParkingLot(1);
        ParkingLot parkingLotM2 = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(List.of(parkingBoyG, parkingBoyS), List.of(parkingLotM1, parkingLotM2));
        parkingManager.pick(ticket);

        //Assert
        Assertions.assertThrows(InvalidTicketPickingFailException.class, () -> parkingManager.pick(ticket));
    }
}
