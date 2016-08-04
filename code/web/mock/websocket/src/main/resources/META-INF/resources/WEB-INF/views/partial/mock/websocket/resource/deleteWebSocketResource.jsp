<%@ include file="../../../../includes.jspf"%>
<%--
  ~ Copyright 2016 Karl Dahlgren
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~   http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>

<div class="content-top">
<h1><spring:message code="websocket.deleteresource.header.deleteresource" arguments="${webSocketResource.name}"/></h1>
</div>
<spring:message code="websocket.deleteresource.label.confirmation" arguments="${webSocketResource.name}"/>

<p>
<a href="<c:url value="/web/wss/project/${webSocketProjectId}/topic/${webSocketTopicId}/resource/${webSocketResource.id}/delete/confirm"/>" class="button-error pure-button"><i class="fa fa-trash"></i> <spring:message code="websocket.deleteresource.button.deleteresource"/></a>
<a href="<c:url value="/web/wss/project/${webSocketProjectId}/topic/${webSocketTopicId}/resource/${webSocketResource.id}"/>" class="button-secondary pure-button"><i class="fa fa-times"></i> <spring:message code="websocket.deleteresource.button.cancel"/></a>
</p>