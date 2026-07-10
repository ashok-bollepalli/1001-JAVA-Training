package in.ashokit.mapper;

import org.modelmapper.ModelMapper;

import in.ashokit.dto.StateDto;
import in.ashokit.entity.StateEntity;

public class StateMapper {

	public static final ModelMapper mapper = new ModelMapper();

	public static StateDto convertToDto(StateEntity entity) {
		return mapper.map(entity, StateDto.class);
	}

	public static StateEntity covertToEntity(StateDto dto) {
		return mapper.map(dto, StateEntity.class);
	}

}
