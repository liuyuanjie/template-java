package org.oobootcamp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class GraduateParkingBoyTest {
    @Test
    void should_pack_into_A_success_and_return_ticket_when_pack_given_parkingLot_A_B_C_in_order_and_A_has_free_parking_place() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot("A", 1));
        parkingLots.add(new ParkingLot("B", 1));
        parkingLots.add(new ParkingLot("C", 1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );
        Car car = new Car();

        // Act
        ParkResult parkResult = graduateParkingBoy.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isTrue();
        assertThat(parkResult.ticket.parkingLot.name).isEqualTo("A");
    }

    @Test
    void should_pack_into_C_success_and_return_ticket_when_pack_given_parkingLot_A_B_C_in_order_and_A_and_B_do_not_have_free_parking_place_And_C_has_free_parking_place() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);
        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);
        parkingLots.add(new ParkingLot("C", 1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );
        Car car = new Car();

        // Act
        ParkResult parkResult = graduateParkingBoy.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isTrue();
        assertThat(parkResult.ticket.parkingLot.name).isEqualTo("C");
    }

    @Test
    void should_pack_car_fail_when_pack_given_parkingLot_A_B_C_in_order_and_all_of_A_B_and_C_do_not_have_free_parking_place() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);

        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);

        ParkingLot parkingLotC = new ParkingLot("C", 1);
        parkingLotC.park(new Car());
        parkingLots.add(parkingLotC);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );
        Car car = new Car();

        // Act
        ParkResult parkResult = graduateParkingBoy.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isFalse();
        assertThat(parkResult.message()).isEqualTo("Parking lot is full, parking failed.");
    }

    @Test
    void should_pick_success_when_pick_given_use_valid_ticket_and_car_can_be_found_in_parkingLot_A() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        ParkResult parkResult = parkingLotA.park(car);
        parkingLots.add(parkingLotA);

        parkingLots.add(new ParkingLot("B", 1));
        parkingLots.add(new ParkingLot("C", 1));

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.ticket);

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
        assertThat(pickResult.car).isEqualTo(car);
    }

    @Test
    void should_pick_success_when_pick_given_use_valid_ticket_and_car_can_be_found_in_parkingLot_C() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);

        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);

        ParkingLot parkingLotC = new ParkingLot("C", 1);
        ParkResult parkResult = parkingLotC.park(car);
        parkingLots.add(parkingLotC);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.ticket);

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
        assertThat(pickResult.car).isEqualTo(car);
    }

    @Test
    void should_pick_fail_when_pick_given_use_invalid_ticket() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);

        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);

        ParkingLot parkingLotC = new ParkingLot("C", 1);
        parkingLotC.park(new Car());
        parkingLots.add(parkingLotC);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );

        Ticket fakeTicket = new Ticket(new ParkingLot("D",1));

        // Act
        PickResult pickResult = graduateParkingBoy.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo("Invalid ticket");
    }

    @Test
    void should_pick_fail_when_pick_given_ticket_has_already_been_used() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);

        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);

        ParkingLot parkingLotC = new ParkingLot("C", 1);
        ParkResult parkResult = parkingLotC.park(new Car());
        parkingLots.add(parkingLotC);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(
                parkingLots
        );
        graduateParkingBoy.pick(parkResult.ticket);

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.ticket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo("This ticket has been used, the car has been picked");
    }
}
