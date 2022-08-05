package org.oobootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;


public class ParkingLotTest {

//    @Rule
//    public ExpectedException exception = ExpectedException.none();

    @Test
    void should_return_parking_success_and_return_ticket_when_park_given_parking_lot_capacity_is_100_and_there_is_0_car() throws ParkFailException {

        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();

        // Act
        Ticket ticket = parkingLot.park(car);

        // Assert
        assertThat(ticket).isNotNull();
    }

    @Test
    void should_return_parking_success_and_return_ticket_when_park_given_parking_lot_capacity_is_100_and_there_is_1_car() throws ParkFailException {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act
        Ticket ticket = parkingLot.park(car);

        // Assert
        assertThat(ticket).isNotNull();
    }

    @Test
    void should_return_parking_failure_and_message_when_park_given_parking_lot_capacity_is_1_and_there_is_1_car() throws ParkFailException {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        Car car = new Car();

        // Act

        // Assert
       // Assertions.assertThrows(ArithmeticException.class, () -> errorMethod());
        Assertions.assertThrows(ParkFailException.class, () -> parkingLot.park(car), "Park failed. Parking lot is full.");
        //assertThat(parkingLot.park(car)).withFailMessage("Park failed. Parking lot is full.");
    }


    @Test
    void should_return_picking_success_when_pick_given_use_valid_ticket_and_car_is_in_parking() throws ParkFailException, PickFailException {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // Act
       car =  parkingLot.pick(ticket);

        // Assert
        assertThat(car).isNotNull();
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_use_invalid_ticket() throws PickFailException, ParkFailException {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
        parkingLot.park(car);

        Ticket fakeTicket = new Ticket();

        // Act


        // Assert
        //Assertions.assertThrows(PickFailException.class, (Executable) parkingLot.pick(fakeTicket));

        Assertions.assertThrows(PickFailException.class, () -> parkingLot.pick(fakeTicket), "Pick failed. Invalid ticket.");
//        Assertions.assertThrows(ParkFailException.class, () -> {
//                    parkingLot.pick(fakeTicket);
//                });

       // assertThat( parkingLot.pick(fakeTicket)).withFailMessage("Pick failed. Invalid ticket.");
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_ticket_has_already_been_picked() throws PickFailException, ParkFailException {
        // Arrange
        ParkingLot parkingLot = new ParkingLot(100);
        Car car = new Car();
      Ticket ticket  = parkingLot.park(car);
        parkingLot.pick(ticket);

        // Act


        // Assert
        Assertions.assertThrows(PickFailException.class, () -> parkingLot.pick(ticket), "Pick failed. ticket has been used.");
       // assertThat(parkingLot.pick(ticket)).withFailMessage("Pick failed. ticket has been used.");
    }
}
