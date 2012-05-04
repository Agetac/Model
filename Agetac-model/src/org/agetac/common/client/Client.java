package org.agetac.common.client;

import java.util.Collection;
import java.util.Date;

import org.agetac.common.dto.ActionDTO;
import org.agetac.common.dto.ActionDTO.ActionType;
import org.agetac.common.dto.InterventionDTO;
import org.agetac.common.dto.MessageDTO;
import org.agetac.common.dto.PositionDTO;
import org.agetac.common.dto.SourceDTO;
import org.agetac.common.dto.TargetDTO;
import org.agetac.common.dto.VehicleDTO;
import org.agetac.common.dto.VehicleDTO.VehicleState;
import org.agetac.common.dto.VehicleDTO.VehicleType;
import org.agetac.common.dto.VehicleDemandDTO;
import org.agetac.common.dto.VehicleDemandDTO.DemandState;
import org.agetac.common.dto.VictimDTO;

public class Client {

	public static void main(String[] args) {

		AgetacClient c = new AgetacClient("148.60.3.104", 8888);
		
		// Create new intervention.
		InterventionDTO intervention = c.createIntervention();
		intervention.setPosition(new PositionDTO(48115436 ,-1638084));
		c.updateIntervention(intervention);

//		long interId = intervention.getId();
//
//		// How many do we have?
//		Collection<InterventionDTO> interventions = c.getInterventions();
//		System.out.println("Interventions: " + interventions.size());
//
//		playWithVehicleDemands(c, interId);
//
//	    playWithMessages(c, interId);
//
//		playWithSources(c, interId);
//
//		playWithActions(c, interITd);
//
//		playWithTargets(c, interId);
//
//		playWithVictims(c, interId);
//		
//		playWithVehicle(c, interId);
	}

	private static void playWithVictims(AgetacClient c, long interId) {
		// Add victim to intervention.
		VictimDTO victim = c.addVictim(interId, new VictimDTO());

		// Add second victim.
		victim = c.addVictim(interId, new VictimDTO());

		// List victims.
		Collection<VictimDTO> victims = c.getVictims(interId);
		System.out.println("Victims: " + victims.size());

		// Update the victim we just added.
		victim.setName("George");
		c.updateVictim(victim);

		// Delete the victim.
		c.deleteVictim(victim.getId());

		// List victims.
		victims = c.getVictims(interId);
		System.out.println("Victims: " + victims.size());
	}

	private static void playWithTargets(AgetacClient c, long interId) {
		// Add targets to intervention.
		TargetDTO target = new TargetDTO();
		c.addTarget(interId, target);

		// List targets.
		Collection<TargetDTO> targets = c.getTargets(interId);
		System.out.println("Targets: " + targets.size());

		// Update the target we just added.
		target.setName("Building A");
		c.updateTarget(target);

		// Delete the target.
		c.deleteTarget(target.getId());

		// List targets.
		targets = c.getTargets(interId);
		System.out.println("Targets: " + targets.size());
	}

	private static void playWithSources(AgetacClient c, long interId) {
		// Add sources to intervention.
		SourceDTO source = new SourceDTO();
		c.addSource(interId, source);

		// List sources.
		Collection<SourceDTO> sources = c.getSources(interId);
		System.out.println("Sources: " + sources.size());

		// Update the source we just added.
		source.setPosition(new PositionDTO(0, 0));
		c.updateSource(source);

		// Delete the source.
		c.deleteSource(source.getId());

		// List sources.
		sources = c.getSources(interId);
		System.out.println("Sources: " + sources.size());
	}
	
	private static void playWithActions(AgetacClient c, long interId) {
		// Add sources to intervention.
		ActionDTO action = new ActionDTO(ActionType.HUMAN);
		c.addAction(interId, action);

		// List sources.
		Collection<ActionDTO> actions = c.getActions(interId);
		System.out.println("Actions: " + actions.size());
		
		// TODO : size should be 1, not 0 ...

		// Update the source we just added.
		action.setPosition(new PositionDTO(0, 0));
		c.updateAction(action);

		// Delete the source.
		c.deleteAction(action.getId());

		// List sources.
		actions = c.getActions(interId);
		System.out.println("Actions: " + actions.size());
	}

	private static void playWithMessages(AgetacClient c, long interId) {
		// Add messages to intervention.
		MessageDTO message = new MessageDTO();
		message.setText("Hello, world!");
		c.addMessage(interId, message);

		// List messages.
		Collection<MessageDTO> messages = c.getMessages(interId);
		System.out.println("Messages: " + messages.size());

		// NOTE I would say that a message is an immutable object. Once sent to
		// the server, it cannot be changed, nor deleted.
		// Max: And I totally agree
	}

	private static void playWithVehicleDemands(AgetacClient c, long interId) {
		// Add a vehicle demand.
		VehicleDemandDTO vd = new VehicleDemandDTO();
		vd.setState(DemandState.ASKED);
		vd.setType(VehicleType.BLS);
		vd.setName("Foo");
		vd.setTimestamp(new Date());
		c.addVehicleDemand(interId, vd);

		// Print the number of vehicle demands for this intervention.
		Collection<VehicleDemandDTO> vehicleDemands = c
				.getVehicleDemands(interId);
		System.out.println("Vehicle demands: " + vehicleDemands.size());
		
		System.out.println("la demande: "+c.getVehicleDemands(0).toArray()[0].toString());
		
		vd.setName("bar");
		c.updateVehicleDemand(vd);
		System.out.println("la demande: "+c.getVehicleDemands(0).toArray()[0].toString());
	}
	
	private static void playWithVehicle(AgetacClient c, long interId) {
		// Add a vehicle demand.
		VehicleDTO vehicle = new VehicleDTO("name", VehicleState.ALERTE, VehicleType.BEA, new PositionDTO(), null);
		c.addVehicle(interId, vehicle);

		// Print the number of vehicle demands for this intervention.
		Collection<VehicleDTO> vehicles = c.getVehicles(interId);
		System.out.println("Vehicles: " + vehicles.size());
	}
}
