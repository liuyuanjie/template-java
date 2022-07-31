package org.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingLotTest {

    @Test
    void Should_park_success_When_park_Given_parking_lot_is_empty() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        // Act
        ParkResult parkResult =  parkingLot.park(car);

        // Assert
        assertThat(parkResult.hasTicket()).isTrue();
    }

    @Test
    void Should_park_success_When_park_Given_parking_lot_capability_is_100_and_remaining_space_is_99() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.park(car1);

        // Act
        ParkResult parkResult =  parkingLot.park(car2);

        // Assert
        assertThat(parkResult.hasTicket()).isTrue();
    }

    @Test
    void Should_park_Fail_When_park_Given_parking_lot_capability_is_1_and_remaining_space_is_0() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.park(car1);

        // Act
        ParkResult parkResult =  parkingLot.park(car2);

        // Assert
        assertThat(parkResult.hasTicket()).isFalse();
        assertThat(parkResult.message()).isEqualTo("Parking lot is full, parking failed.");
    }
    @Test
    void Should_pick_Success_When_pick_Given_use_valid_ticket() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);

        // Act
        PickResult pickResult =  parkingLot.pick(parkResult.ticket);

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
    }

    @Test
    void Should_pick_fail_When_pick_Given_use_invalid_ticket() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);

        Ticket fakeTicket = new Ticket();
        // Act
        PickResult pickResult =  parkingLot.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
    }

    @Test
    void Should_pick_fail_When_pick_Given_ticket_has_already_been_used() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        ParkResult parkResult = parkingLot.park(car);

        // Act
        PickResult pickResult =  parkingLot.pick(parkResult.ticket);

        pickResult =  parkingLot.pick(parkResult.ticket);
        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
    }
}
