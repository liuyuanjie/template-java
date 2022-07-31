package org.oobootcamp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.oobootcamp.Constants.*;

public class GraduateParkingBoyTest {
    @Test
    void should_return_packing_success_into_A_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_A_has_free_parking() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot("A", 100));
        parkingLots.add(new ParkingLot("B", 1));
        parkingLots.add(new ParkingLot("C", 1));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);
        Car car = new Car();

        // Act
        ParkResult parkResult = graduateParkingBoy.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isTrue();
        assertThat(parkResult.getTicket().getParkingLot().name).isEqualTo("A");
    }

    @Test
    void should_return_packing_success_into_C_and_return_ticket_when_pack_given_parkingLots_A_B_C_in_order_and_A_and_B_do_not_have_free_parking_place_And_C_has_free_parking() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);

        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);

        parkingLots.add(new ParkingLot("C", 100));
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);
        Car car = new Car();

        // Act
        ParkResult parkResult = graduateParkingBoy.park(car);

        // Assert
        assertThat(parkResult.isSuccess()).isTrue();
        assertThat(parkResult.getTicket().getParkingLot().name).isEqualTo("C");
    }

    @Test
    void should_return_packing_failure_when_pack_given_parkingLots_A_B_C_in_order_and_all_of_A_B_and_C_do_not_have_free_parking() {
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
        assertThat(parkResult.isSuccess()).isFalse();
        assertThat(parkResult.getMessage()).isEqualTo(PARKING_LOT_WAS_FULL_FAILED_TO_PACK);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_parkingLot_A_ticket_and_car_was_in_parkingLot_A() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        ParkResult parkResult = parkingLotA.park(car);
        parkingLots.add(parkingLotA);

        parkingLots.add(new ParkingLot("B", 1));
        parkingLots.add(new ParkingLot("C", 1));

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
        assertThat(pickResult.getCar()).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_parkingLot_C_ticket_and_car_was_in_parkingLot_C() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();

        parkingLots.add(new ParkingLot("A", 1));
        parkingLots.add(new ParkingLot("C", 1));

        ParkingLot parkingLotC = new ParkingLot("C", 1);
        ParkResult parkResult = parkingLotC.park(car);
        parkingLots.add(parkingLotC);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
        assertThat(pickResult.getCar()).isEqualTo(car);
    }

    @Test
    void should_return_picking_success_when_pick_given_parkingLots_A_B_C_and_valid_ticket_and_car_was_not_in_parkingLot_A_B_and_C() {
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

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isTrue();
        assertThat(pickResult.getCar()).isEqualTo(car);
    }

    @Test
    void should_return_picking_failure_and_message_when_pick_given_parkingLots_A_B_C_and_invalid_ticket() {
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

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);

        Ticket fakeTicket = new Ticket(new ParkingLot("D", 1));

        // Act
        PickResult pickResult = graduateParkingBoy.pick(fakeTicket);

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo(INVALID_TICKET_THE_CAR_CAN_NOT_BE_FOUND);
    }

    @Test
    void should_return_picking_failure_and_messge_when_pick_given_parkingLots_A_B_C_and_ticket_has_already_been_picked() {
        // Arrange
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot parkingLotA = new ParkingLot("A", 1);
        parkingLotA.park(new Car());
        parkingLots.add(parkingLotA);

        ParkingLot parkingLotB = new ParkingLot("B", 1);
        parkingLotB.park(new Car());
        parkingLots.add(parkingLotB);

        ParkingLot parkingLotC = new ParkingLot("C", 1);
        ParkResult parkResult = parkingLotC.park(new Car());
        parkingLots.add(parkingLotC);

        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);
        graduateParkingBoy.pick(parkResult.getTicket());

        // Act
        PickResult pickResult = graduateParkingBoy.pick(parkResult.getTicket());

        // Assert
        assertThat(pickResult.isSuccess()).isFalse();
        assertThat(pickResult.getMessage()).isEqualTo(THIS_TICKET_HAS_EXPIRED_THE_CAR_HAS_BEEN_PICKED);
    }
}
