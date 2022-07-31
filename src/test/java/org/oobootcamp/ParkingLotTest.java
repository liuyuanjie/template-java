package org.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotTest {

    @Test
    void should_park_success_and_return_ticket_when_park_given_parking_lot_capability_is_100_and_there_is_0_car() {

        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isTrue();
    }

    @Test
    void should_park_success_and_return_ticket_when_park_given_parking_lot_capability_is_100_and_there_is_1_car() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isTrue();
    }

    @Test
    void should_park_fail_when_park_given_parking_lot_capability_is_1_and_there_is_1_car() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isFalse();
        assertThat(parkResult.getMessage()).isEqualTo("Parking lot is full, parking failed.");
    }

    @Test
    void should_pick_success_when_pick_given_use_valid_ticket_and_car_can_be_found() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);

        // Act
        PickResult pickResult = parkingLot.pick(parkResult.ticket);

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
    }

    @Test
    void should_pick_fail_when_pick_given_use_invalid_ticket() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);

        Ticket fakeTicket = new Ticket(parkingLot);

        // Act
        PickResult pickResult = parkingLot.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo("Invalid ticket");
    }

    @Test
    void should_pick_fail_shen_pick_given_ticket_has_already_been_used() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);
        PickResult pickResult = parkingLot.pick(parkResult.ticket);

        // Act
        pickResult = parkingLot.pick(parkResult.ticket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo("This ticket has been used, the car has been picked");
    }
}
