package org.oobootcamp;

import org.junit.jupiter.api.Test;
import org.oobootcamp.IparkingWay.SmartParking;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartParkingBoyTest {
    @Test
    void should_return_parking_success_into_B_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_all_A_B_C_capacity_are_3_and_A_has_1_car_B_has_0_car_and_C_has_1_car() {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(3);
        parkingLotA.park(new Car());
        ParkingLot parkingLotB = new ParkingLot(3);
        ParkingLot parkingLotC = new ParkingLot(3);
        parkingLotC.park(new Car());

        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Act
        ParkResult result = smartParkingBoy.park(car);

        // Assert
        assertThat(parkingLotB.pick(result.getTicket()).isSuccess()).isTrue();
    }

    @Test
    void should_return_parking_success_into_A_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_all_A_B_C_capacity_are_3_and_all_have_0_car() {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(3);
        ParkingLot parkingLotC = new ParkingLot(3);
        parkingLotC.park(new Car());

        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Act
        ParkResult result = smartParkingBoy.park(car);

        // Assert
        assertThat(parkingLotA.pick(result.getTicket()).isSuccess()).isTrue();
    }

    @Test
    void should_return_parking_failure_when_pack_given_parkingLots_A_B_C_in_order_and_all_A_B_C_capacity_are_1_and_all_have_1_car() {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());
        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());
        ParkingLot parkingLotC = new ParkingLot(1);
        parkingLotC.park(new Car());

        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Act
        ParkResult parkResult = smartParkingBoy.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isFalse();
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_use_valid_parkingLot_A_ticket_and_car_was_in_parkingLot_A() {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        ParkResult parkResult = parkingLotA.park(car);

        ParkingLot parkingLotB = new ParkingLot(1);
        ParkingLot parkingLotC = new ParkingLot(1);
        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        PickResult pickResult = smartParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.getCar()).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_use_valid_parkingLot_C_ticket_and_car_was_in_parkingLot_C() {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);
        ParkingLot parkingLotC = new ParkingLot(1);
        ParkResult parkResult = parkingLotC.park(car);

        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        PickResult pickResult = smartParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.getCar()).isEqualTo(car);
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_use_invalid_ticket() {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        parkingLotC.park(new Car());

        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));

        Ticket fakeTicket = new Ticket();

        // Act
        PickResult pickResult = smartParkingBoy.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_ticket_has_already_been_picked() {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());
        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());
        ParkingLot parkingLotC = new ParkingLot(1);

        ParkResult parkResult = parkingLotC.park(new Car());

        ParkingLotBoy smartParkingBoy = new ParkingLotBoy(new SmartParking(), List.of(parkingLotA, parkingLotB, parkingLotC));
        smartParkingBoy.pick(parkResult.getTicket());

        // Act
        PickResult pickResult = smartParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
    }
}
