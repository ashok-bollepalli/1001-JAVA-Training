package in.ashokit.mapper;

import org.modelmapper.ModelMapper;

import in.ashokit.dto.UserDto;
import in.ashokit.entity.UserEntity;

public class UserMapper {

	public static final ModelMapper mapper = new ModelMapper();

	public static UserDto convertToDto(UserEntity userEntity) {
		return mapper.map(userEntity, UserDto.class);
	}

	public static UserEntity covertToEntity(UserDto userDto) {
		return mapper.map(userDto, UserEntity.class);
	}

}
