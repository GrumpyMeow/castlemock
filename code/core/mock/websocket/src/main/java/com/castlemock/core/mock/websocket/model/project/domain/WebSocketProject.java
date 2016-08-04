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

package com.castlemock.core.mock.websocket.model.project.domain;

import com.castlemock.core.basis.model.project.domain.Project;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Karl Dahlgren
 * @since 1.5
 */
@XmlRootElement
public class WebSocketProject extends Project {

    private List<WebSocketTopic> topics;

    @XmlElementWrapper(name = "topics")
    @XmlElement(name = "topic")
    public List<WebSocketTopic> getTopics() {
        return topics;
    }

    public void setTopics(List<WebSocketTopic> topics) {
        this.topics = topics;
    }
}
