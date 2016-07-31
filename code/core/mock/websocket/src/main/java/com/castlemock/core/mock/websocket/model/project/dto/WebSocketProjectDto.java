/*
 * Copyright 2016 Karl Dahlgren
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.castlemock.core.mock.websocket.model.project.dto;

import com.castlemock.core.basis.model.project.dto.ProjectDto;
import org.dozer.Mapping;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Karl Dahlgren
 * @since 1.5
 */
public class WebSocketProjectDto extends ProjectDto {

    @Mapping("applications")
    private List<WebSocketApplicationDto> applications = new LinkedList<WebSocketApplicationDto>();

    /**
     * The default WebSocket project constructor
     */
    public WebSocketProjectDto() {
    }

    /**
     * The constructor will create a new WebSocket project DTO based on the provided projectDto
     * @param projectDto The new WebSocket project DTO will be based on the provided project DTO and contain
     *                   the same information as the provided project DTO
     */
    public WebSocketProjectDto(final ProjectDto projectDto){
        super(projectDto);
    }


    public List<WebSocketApplicationDto> getApplications() {
        return applications;
    }

    public void setApplications(List<WebSocketApplicationDto> applications) {
        this.applications = applications;
    }
}
