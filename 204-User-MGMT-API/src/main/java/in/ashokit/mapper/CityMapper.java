package in.ashokit.mapper;

import org.modelmapper.ModelMapper;

import in.ashokit.dto.CityDto;
import in.ashokit.entity.CityEntity;

public class CityMapper {

	public static final ModelMapper mapper = new ModelMapper();

	public static CityDto convertToDto(CityEntity entity) {
		return mapper.map(entity, CityDto.class);
	}

	public static CityEntity covertToEntity(CityDto dto) {
		return mapper.map(dto, CityEntity.class);
	}

}
