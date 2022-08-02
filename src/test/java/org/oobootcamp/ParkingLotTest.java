package org.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotTest {

    @Test
    void should_return_parking_success_and_return_ticket_when_park_given_parking_lot_capacity_is_100_and_has_0_car() {

        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.getTicket()).isNotNull();
    }

    @Test
    void should_return_parking_success_and_return_ticket_when_park_given_parking_lot_capacity_is_100_and_has_1_car() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.getTicket()).isNotNull();
    }

    @Test
    void should_return_parking_failure_and_message_when_park_given_parking_lot_capacity_is_1_and_has_1_car() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isFalse();
    }

    @Test
    void should_return_picking_success_when_pick_given_use_valid_ticket_and_car_is_in_parking() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);

        // Act
        PickResult pickResult = parkingLot.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_use_invalid_ticket() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        parkingLot.park(car);

        Ticket fakeTicket = new Ticket();

        // Act
        PickResult pickResult = parkingLot.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_ticket_has_already_been_picked() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);
        parkingLot.pick(parkResult.getTicket());

        // Act
        PickResult pickResult = parkingLot.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
    }
}
