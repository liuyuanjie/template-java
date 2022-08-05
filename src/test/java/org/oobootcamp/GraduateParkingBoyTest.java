package org.oobootcamp;

import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

import static org.assertj.core.api.Assertions.assertThat;


public class GraduateParkingBoyTest {
    @Test
    void should_return_packing_success_into_A_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_all_A_B_C_capacity_is_1() throws PickFailException, ParkFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);
        ParkingLot parkingLotC = new ParkingLot(1);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Act
       Ticket ticket = graduateParkingBoy.park(car);
       Car pickedCar =  parkingLotA.pick(ticket);
        // Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_return_packing_success_into_C_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_A_and_B_do_not_have_free_parking_place_And_C_has_free_parking() throws ParkFailException, PickFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(100);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        Car car = new Car();

        // Act
        Ticket ticket = graduateParkingBoy.park(car);
        Car pickedCar =  parkingLotC.pick(ticket);

        // Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_return_packing_failure_when_pack_given_parkingLots_A_B_C_in_order_and_all_of_A_B_and_C_do_not_have_free_parking() throws ParkFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        parkingLotC.park(new Car());

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Act


        // Assert
        Assertions.assertThrows(ParkFailException.class, () -> graduateParkingBoy.park(car), "Park failed. Parking lot is full.");
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_parkingLot_A_ticket_and_car_was_in_parkingLot_A() throws ParkFailException, PickFailException {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        Ticket ticket = parkingLotA.park(car);

        ParkingLot parkingLotB = new ParkingLot(1);
        ParkingLot parkingLotC = new ParkingLot(1);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        Car pickRedCar = graduateParkingBoy.pick(ticket);

        // Assert
        assertThat(pickRedCar).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_parkingLot_C_ticket_and_car_was_in_parkingLot_C() throws ParkFailException, PickFailException {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        ParkingLot parkingLotC = new ParkingLot(1);
        Ticket ticket = parkingLotC.park(car);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        Car pickRedCar = graduateParkingBoy.pick(ticket);

        // Assert
        assertThat(pickRedCar).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_ticket_and_car_was_not_in_parkingLot_A_B_and_C() throws ParkFailException, PickFailException {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        Ticket ticket = parkingLotC.park(car);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        Car pickRedCar = graduateParkingBoy.pick(ticket);

        // Assert
        assertThat(pickRedCar).isEqualTo(car);
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_invalid_ticket() throws ParkFailException, PickFailException{
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        parkingLotC.park(new Car());

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        Ticket fakeTicket = new Ticket();

        // Act


        // Assert
        Assertions.assertThrows(PickFailException.class, () -> graduateParkingBoy.pick(fakeTicket), "Pick failed. Invalid ticket.");
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_ticket_has_already_been_picked() throws ParkFailException, PickFailException{
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        Ticket ticket = parkingLotC.park(new Car());

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));
        graduateParkingBoy.pick(ticket);

        // Act


        // Assert
        Assertions.assertThrows(PickFailException.class, () -> graduateParkingBoy.pick(ticket), "Pick failed. ticket has been used.");
    }
}
