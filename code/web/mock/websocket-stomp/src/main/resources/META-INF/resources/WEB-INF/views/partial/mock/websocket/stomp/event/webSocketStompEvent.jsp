<%--
 Copyright 2016 Karl Dahlgren

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>

<%@ include file="../../../../../includes.jspf"%>
<div class="content-top">
    <h1><spring:message code="websocket.stomp.event.header.log" arguments="${event.id}"/></h1>
</div>

<div class="content-summary">
    <table class="formTable">
        <tr>
            <td class="column1"><label path="name"><spring:message code="websocket.stomp.event.column.id"/></label></td>
            <td class="column2"><label path="name">${event.id}</label></td>
        </tr>
        <tr>
            <td class="column1"><label path="name"><spring:message code="websocket.stomp.event.column.startdate"/></label></td>
            <td class="column2"><label path="name">${event.startDate}</label></td>
        </tr>
        <tr>
            <td class="column1"><label path="name"><spring:message code="websocket.stomp.event.column.enddate"/></label></td>
            <td class="column2"><label path="name">${event.endDate}</label></td>
        </tr>
        <tr>
            <td class="column1"><label path="name"><spring:message code="websocket.stomp.event.column.request.uri"/></label></td>
            <td class="column2"><label path="name">${event.request.uri}</label></td>
        </tr>
        <tr>
            <td class="column1"><label path="name"><spring:message code="websocket.stomp.event.column.request.methodtype"/></label></td>
            <td class="column2"><label path="name">${event.request.httpMethod}</label></td>
        </tr>
    </table>
</div>

<div>
    <h2 class="decorated"><span><spring:message code="websocket.stomp.event.header.request"/></span></h2>
    <h3><span><spring:message code="websocket.stomp.event.header.body"/></span></h3>
    <div class="eventMessage">
        <textarea id="requestBody" readonly><c:out value="${event.request.body}"/></textarea>
    </div>
    <c:choose>
        <c:when test="${event.request.httpHeaders.size() > 0}">
            <h3><span><spring:message code="websocket.stomp.event.header.headers"/></span></h3>
            <div class="table-frame">
                <table class="entityTable">
                    <tr>
                        <th><spring:message code="websocket.stomp.event.column.headername"/></th>
                        <th><spring:message code="websocket.stomp.event.column.headervalue"/></th>
                    </tr>
                    <c:forEach items="${event.request.httpHeaders}" var="httpHeader" varStatus="loopStatus">
                        <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                            <td>${httpHeader.name}</td>
                            <td>${httpHeader.value}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:when>
    </c:choose>
</div>

<div>
    <h2 class="decorated"><span><spring:message code="websocket.stomp.event.header.response"/></span></h2>
    <table class="formTable">
        <tr>
            <td class="column1"><label path="name"><spring:message code="websocket.stomp.event.column.response.statuscode"/></label></td>
            <td class="column2"><label path="name">${event.response.httpStatusCode}</label></td>
        </tr>
    </table>
    <h3><span><spring:message code="websocket.stomp.event.header.body"/></span></h3>
    <div class="eventMessage">
        <textarea id="responseBody" readonly><c:out value="${event.response.body}"/></textarea>
    </div>

    <c:choose>
        <c:when test="${event.response.httpHeaders.size() > 0}">
            <h3><span><spring:message code="websocket.stomp.event.header.headers"/></span></h3>
            <div class="table-frame">
                <table class="entityTable">
                    <tr>
                        <th><spring:message code="websocket.stomp.event.column.headername"/></th>
                        <th><spring:message code="websocket.stomp.event.column.headervalue"/></th>
                    </tr>
                    <c:forEach items="${event.response.httpHeaders}" var="httpHeader" varStatus="loopStatus">
                        <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                            <td>${httpHeader.name}</td>
                            <td>${httpHeader.value}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:when>
    </c:choose>
</div>

