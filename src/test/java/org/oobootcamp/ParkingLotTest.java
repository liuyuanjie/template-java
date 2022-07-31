package org.oobootcamp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oobootcamp.Constants.*;

public class ParkingLotTest {

    @Test
    void should_return_parking_success_and_return_ticket_when_park_given_parking_lot_has_100_parking_and_there_is_0_car() {

        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isTrue();
        assertThat(parkResult.getTicket()).isNotNull();
    }

    @Test
    void should_return_parking_success_and_return_ticket_when_park_given_parking_lot_has_100_parking_and_there_is_1_car() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isTrue();
        assertThat(parkResult.getTicket()).isNotNull();
    }

    @Test
    void should_return_parking_failure_and_message_when_park_given_parking_lot_has_1_parking_and_there_is_1_car() {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        ParkResult parkResult = parkingLot.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isFalse();
        assertThat(parkResult.getMessage()).isEqualTo(PARKING_LOT_WAS_FULL_FAILED_TO_PACK);
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

        Ticket fakeTicket = new Ticket(parkingLot);

        // Act
        PickResult pickResult = parkingLot.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo(INVALID_TICKET_THE_CAR_CAN_NOT_BE_FOUND);
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
        assertThat(pickResult.getMessage()).isEqualTo(THIS_TICKET_HAS_EXPIRED_THE_CAR_HAS_BEEN_PICKED);
    }
}
