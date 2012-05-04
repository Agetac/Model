package org.agetac.common.client;

import java.io.IOException;
import java.util.Collection;

import org.agetac.common.dto.ActionDTO;
import org.agetac.common.dto.InterventionDTO;
import org.agetac.common.dto.MessageDTO;
import org.agetac.common.dto.SourceDTO;
import org.agetac.common.dto.TargetDTO;
import org.agetac.common.dto.VehicleDTO;
import org.agetac.common.dto.VehicleDemandDTO;
import org.agetac.common.dto.VictimDTO;
import org.agetac.common.resources.ActionResource;
import org.agetac.common.resources.ActionsResource;
import org.agetac.common.resources.InterventionResource;
import org.agetac.common.resources.MessageResource;
import org.agetac.common.resources.MessagesResource;
import org.agetac.common.resources.SourceResource;
import org.agetac.common.resources.SourcesResource;
import org.agetac.common.resources.TargetResource;
import org.agetac.common.resources.TargetsResource;
import org.agetac.common.resources.VehicleDemandResource;
import org.agetac.common.resources.VehicleDemandsResource;
import org.agetac.common.resources.VehicleResource;
import org.agetac.common.resources.VehiclesResource;
import org.agetac.common.resources.VictimResource;
import org.agetac.common.resources.VictimsResource;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class AgetacClient {

	private final String host;
	private final int port;

	/**
	 * Construit un objet permettant d'effectuer toutes les operations REST sur
	 * le serveur
	 * 
	 * @param host
	 *            server host
	 * @param port
	 *            server port
	 */
	public AgetacClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public Collection<VehicleDemandDTO> getVehicleDemands(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/vehicledemands");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<VehicleDemandDTO>> tr = new TypeReference<Collection<VehicleDemandDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<VehicleDemandDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
		} finally {
			clientResource.release();
		}

	}

	public VehicleDemandDTO addVehicleDemand(long interId,
			VehicleDemandDTO vehicleDemand) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/vehicledemand");
		try {
			VehicleDemandResource vehicleDemandResource = clientResource
					.wrap(VehicleDemandResource.class);

			return vehicleDemandResource.add(vehicleDemand);
		} finally {
			clientResource.release();
		}

	}

	public VehicleDTO addVehicle(long interId, VehicleDTO vehicle) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/vehicle");
		try {
			VehicleResource vehicleResource = clientResource
					.wrap(VehicleResource.class);

			return vehicleResource.add(vehicle);
		} finally {
			clientResource.release();
		}
	}

	public Collection<InterventionDTO> getInterventions() {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/interventions");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<InterventionDTO>> tr = new TypeReference<Collection<InterventionDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<InterventionDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return col;

		} finally {
			clientResource.release();
		}

	}

	private static ClientResource makeClientResource(String address) {
		ClientResource clientResource = new ClientResource(address);
		clientResource.setEntityBuffering(true);
		return clientResource;
	}

	public InterventionDTO createIntervention() {
		InterventionDTO intervention = new InterventionDTO();

		// Add it.
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention");
		try {
			InterventionResource interventionResource = clientResource
					.wrap(InterventionResource.class);

			return interventionResource.add(intervention);
		} finally {
			clientResource.release();
		}
	}

	public MessageDTO addMessage(long interId, MessageDTO message) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/message");
		try {
			MessageResource messageResource = clientResource
					.wrap(MessageResource.class);

			return messageResource.add(message);
		} finally {
			clientResource.release();
		}

	}

	public SourceDTO addSource(long interId, SourceDTO source) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/source");
		try {
			SourceResource sourceResource = clientResource
					.wrap(SourceResource.class);

			return sourceResource.add(source);
		} finally {
			clientResource.release();
		}

	}

	public TargetDTO addTarget(long interId, TargetDTO target) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/target");
		try {
			TargetResource targetResource = clientResource
					.wrap(TargetResource.class);

			return targetResource.add(target);
		} finally {
			clientResource.release();
		}

	}

	public VictimDTO addVictim(long interId, VictimDTO victim) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/victim");
		try {
			VictimResource resource = clientResource.wrap(VictimResource.class);

			return resource.add(victim);
		} finally {
			clientResource.release();
		}

	}

	public ActionDTO addAction(long interId, ActionDTO action) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/action");
		try {
			ActionResource resource = clientResource.wrap(ActionResource.class);

			return resource.add(action);
		} finally {
			clientResource.release();
		}

	}

	public Collection<MessageDTO> getMessages(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/messages");
		try {
			
			Representation repr = clientResource.get();

			TypeReference<Collection<MessageDTO>> tr = new TypeReference<Collection<MessageDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<MessageDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
			
		} finally {
			clientResource.release();
		}
	}

	public Collection<VehicleDTO> getVehicles(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/vehicles");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<InterventionDTO>> tr = new TypeReference<Collection<InterventionDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<VehicleDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
		} finally {
			clientResource.release();
		}
	}

	public Collection<ActionDTO> getActions(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/actions");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<ActionDTO>> tr = new TypeReference<Collection<ActionDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<ActionDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
		} finally {
			clientResource.release();
		}
	}

	public Collection<SourceDTO> getSources(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/sources");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<SourceDTO>> tr = new TypeReference<Collection<SourceDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<SourceDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
		} finally {
			clientResource.release();
		}
	}

	public Collection<TargetDTO> getTargets(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/targets");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<TargetDTO>> tr = new TypeReference<Collection<TargetDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<TargetDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
		} finally {
			clientResource.release();
		}
	}

	public Collection<VictimDTO> getVictims(long interId) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + interId + "/victims");
		try {
			Representation repr = clientResource.get();

			TypeReference<Collection<VictimDTO>> tr = new TypeReference<Collection<VictimDTO>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Collection<VictimDTO> col = null;
			try {
				col = mapper.readValue(repr.getStream(), tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return col;
		} finally {
			clientResource.release();
		}
	}

	private String getBaseAddress() {
		return "http://" + host + ":" + port;
	}

	public void updateVictim(VictimDTO victim) {

		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/victim/" + victim.getId());
		try {
			VictimResource resource = clientResource.wrap(VictimResource.class);

			resource.update(victim);
		} finally {
			clientResource.release();
		}

	}

	public void updateVehicle(VehicleDTO vehicle) {

		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/vehicle/" + vehicle.getId());
		try {
			VehicleResource resource = clientResource
					.wrap(VehicleResource.class);

			resource.update(vehicle);
		} finally {
			clientResource.release();
		}

	}

	public void updateTarget(TargetDTO target) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/target/" + target.getId());
		try {
			TargetResource resource = clientResource.wrap(TargetResource.class);

			resource.update(target);
		} finally {
			clientResource.release();
		}
	}

	public void updateSource(SourceDTO source) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/source/" + source.getId());
		try {
			SourceResource resource = clientResource.wrap(SourceResource.class);

			resource.update(source);
		} finally {
			clientResource.release();
		}

	}

	public void updateAction(ActionDTO action) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/action/" + action.getId());
		try {
			ActionResource resource = clientResource.wrap(ActionResource.class);

			resource.update(action);
		} finally {
			clientResource.release();
		}

	}

	public void updateVehicleDemand(VehicleDemandDTO vd) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/vehicledemand/" + vd.getId());
		try {
			VehicleDemandResource resource = clientResource
					.wrap(VehicleDemandResource.class);

			resource.update(vd);
		} finally {
			clientResource.release();
		}
	}

	public void deleteTarget(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/target/" + id);
		try {
			TargetResource resource = clientResource.wrap(TargetResource.class);

			resource.remove();
		} finally {
			clientResource.release();
		}

	}

	public void deleteVictim(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/victim/" + id);
		try {
			VictimResource resource = clientResource.wrap(VictimResource.class);

			resource.remove();
		} finally {
			clientResource.release();
		}
	}

	public void deleteSource(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/source/" + id);
		try {
			SourceResource resource = clientResource.wrap(SourceResource.class);

			resource.remove();
		} finally {
			clientResource.release();
		}
	}

	public void deleteVehicle(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/vehicle/" + id);
		try {
			SourceResource resource = clientResource.wrap(SourceResource.class);

			resource.remove();
		} finally {
			clientResource.release();
		}
	}

	public void deleteAction(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/action/" + id);
		try {
			ActionResource resource = clientResource.wrap(ActionResource.class);

			resource.remove();
		} finally {
			clientResource.release();
		}
	}

	public void deleteVehicleDemand(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/vehicledemand/" + id);
		try {
			SourceResource resource = clientResource.wrap(SourceResource.class);

			resource.remove();
		} finally {
			clientResource.release();
		}
	}

	public InterventionDTO getIntervention(long id) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + id);
		try {
			InterventionResource resource = clientResource
					.wrap(InterventionResource.class);

			return resource.retrieve();
		} finally {
			clientResource.release();
		}
	}

	public void updateIntervention(InterventionDTO intervention) {
		ClientResource clientResource = makeClientResource(getBaseAddress()
				+ "/intervention/" + intervention.getId());
		try {
			InterventionResource resource = clientResource
					.wrap(InterventionResource.class);

			resource.update(intervention);
		} finally {
			clientResource.release();
		}
	}
}
