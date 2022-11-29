package com.project.common;

import java.util.Optional;

public interface EntityMapper<Entity, Request, Reponse> {
    Reponse toResponse(final Entity entity);
    Entity toEntity(final Request dto);
}
