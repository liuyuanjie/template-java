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
        ParkResult parkResult =  parkingLot.Park(car);

        // Assert
        assertThat(parkResult.HasTicket()).isTrue();
    }

    @Test
    void Should_park_success_When_park_Given_parking_lot_capability_is_100_and_remaining_space_is_99() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.Park(car1);

        // Act
        ParkResult parkResult =  parkingLot.Park(car2);

        // Assert
        assertThat(parkResult.HasTicket()).isTrue();
    }

//    @Test
//    void Should_park_Fail_When_park_Given_parking_lot_capability_is_1_and_remaining_space_is_0() {
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car car1 = new Car();
//        ParkResult parkResult =  parkingLot.Park(car1);
//        assertThat(parkResult.IsSuccess());
//        Car car2 = new Car();
//        parkResult =  parkingLot.Park(car2);
//        assertThat(parkResult.IsSuccess()).isEqualTo(false);
//    }

}
