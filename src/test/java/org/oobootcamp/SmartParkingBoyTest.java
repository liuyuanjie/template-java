package org.oobootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartParkingBoyTest {
    @Test
    void should_return_packing_success_into_B_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_B_have_most_empty_parking_spaces() throws ParkingLotIsFullParkingFailException, PickingFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(3);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(3);
        ParkingLot parkingLotC = new ParkingLot(3);
        parkingLotC.park(new Car());

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Act
        Ticket ticket = smartParkingBoy.park(car);

        Car pickedCar = parkingLotB.pick(ticket);
        // Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_return_packing_success_into_A_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_A_B_have_the_same_most_empty_parking_spaces() throws ParkingLotIsFullParkingFailException, PickingFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(3);
        ParkingLot parkingLotC = new ParkingLot(3);
        parkingLotC.park(new Car());

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        Car car = new Car();

        // Act
        Ticket ticket = smartParkingBoy.park(car);

        Car pickedCar = parkingLotA.pick(ticket);

        // Assert
        Assertions.assertEquals(car, pickedCar);
    }

    @Test
    void should_return_packing_failure_when_pack_given_parkingLots_A_B_C_in_order_and_all_of_A_B_and_C_do_not_have_free_parking() throws ParkingLotIsFullParkingFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        parkingLotC.park(new Car());

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));
        Car car = new Car();

        // Assert
        Assertions.assertThrows(ParkingLotIsFullParkingFailException.class, () -> smartParkingBoy.park(car));
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_parkingLot_A_ticket_and_car_was_in_parkingLot_A() throws ParkingLotIsFullParkingFailException, PickingFailException {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        Ticket ticket = parkingLotA.park(car);

        ParkingLot parkingLotB = new ParkingLot(1);
        ParkingLot parkingLotC = new ParkingLot(1);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        Car pickRedCar = smartParkingBoy.pick(ticket);

        // Assert
        assertThat(pickRedCar).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_parkingLot_C_ticket_and_car_was_in_parkingLot_C() throws ParkingLotIsFullParkingFailException, PickingFailException {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);

        ParkingLot parkingLotC = new ParkingLot(1);
        Ticket ticket = parkingLotC.park(car);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        Car pickRedCar = smartParkingBoy.pick(ticket);

        // Assert
        assertThat(pickRedCar).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_ticket_and_car_was_not_in_parkingLot_A_B_and_C() throws PickingFailException, ParkingLotIsFullParkingFailException {
        // Arrange
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        Ticket ticket = parkingLotC.park(car);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        // Act
        Car pickRedCar = smartParkingBoy.pick(ticket);

        // Assert
        assertThat(pickRedCar).isEqualTo(car);
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_invalid_ticket() throws ParkingLotIsFullParkingFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        parkingLotC.park(new Car());

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));

        Ticket fakeTicket = new Ticket();

        // Assert
        Assertions.assertThrows(InvalidTicketPickingFailException.class, () -> smartParkingBoy.pick(fakeTicket));
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_ticket_has_already_been_picked() throws PickingFailException, ParkingLotIsFullParkingFailException {
        // Arrange
        ParkingLot parkingLotA = new ParkingLot(1);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(1);
        parkingLotB.park(new Car());

        ParkingLot parkingLotC = new ParkingLot(1);
        Ticket ticket = parkingLotC.park(new Car());

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(parkingLotA, parkingLotB, parkingLotC));
        smartParkingBoy.pick(ticket);

        // Assert
        Assertions.assertThrows(TicketHasBeenUsedPickingFailException.class, () -> smartParkingBoy.pick(ticket));
    }
}
