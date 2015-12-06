/*
 * Copyright 2015 Karl Dahlgren
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

package com.fortmocks.web.mock.soap.web.mvc.controller.event;

import com.fortmocks.core.mock.soap.model.event.service.message.input.ReadSoapEventInput;
import com.fortmocks.core.mock.soap.model.event.service.message.output.ReadSoapEventOutput;
import com.fortmocks.web.mock.soap.web.mvc.controller.AbstractSoapViewController;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller LogController provides functionality to retrieve logged information
 * and display it to the user
 * @author Karl Dahlgren
 * @since 1.0
 */
@Controller
@Scope("request")
@RequestMapping("/web")
public class SoapEventController extends AbstractSoapViewController {

    private static final String PAGE = "mock/soap/event/soapEvent";

    /**
     * The method creates a view that displays all the logged information to the user
     * @return View with all the logged information
     */
    @PreAuthorize("hasAuthority('READER') or hasAuthority('MODIFIER') or hasAuthority('ADMIN')")
    @RequestMapping(value = "soap/event/{eventId}", method = RequestMethod.GET)
    public ModelAndView defaultPage(@PathVariable final String eventId) {
        final ReadSoapEventOutput output = serviceProcessor.process(new ReadSoapEventInput(eventId));
        final ModelAndView model = createPartialModelAndView(PAGE);
        model.addObject(EVENT, output.getSoapEvent());
        return model;
    }

}