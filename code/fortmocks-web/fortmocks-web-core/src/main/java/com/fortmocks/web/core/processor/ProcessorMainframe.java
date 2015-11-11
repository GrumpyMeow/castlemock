package com.fortmocks.web.core.processor;

import com.fortmocks.core.model.*;
import com.fortmocks.core.model.user.User;
import com.fortmocks.core.model.validation.NotNull;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Karl Dahlgren
 * @since 1.0
 */
@Component
public class ProcessorMainframe {

    @Autowired
    private ProcessorRegistry processorRegistry;

    private static final String UNKNOWN_USER = "Unknown";
    private static final Logger LOGGER = Logger.getLogger(ProcessorMainframe.class);


    public <I extends Input, O extends Output> O process(final I input){
        validateMessage(input);
        final Processor<I,O> processor = processorRegistry.getProcessor(input);
        final Task<I> task = new Task<I>();
        task.setInput(input);
        task.setExecuter(getLoggedInUsername());
        LOGGER.debug(getLoggedInUsername() + " is requesting " + processor.getClass().getSimpleName() + " to process the following input message: " + input.getClass().getSimpleName());
        final Result<O> result = processor.process(task);
        validateMessage(result.getOutput());
        return result.getOutput();
    }

    protected <M extends Message> void validateMessage(final M message){
        if(message == null){
            throw new NullPointerException("The message cannot be null");
        }

        final Class<?> messageClass = message.getClass();
        for(Field field : messageClass.getDeclaredFields()){
            if(field.isAnnotationPresent(NotNull.class)){
                validateNotNull(message, field.getName());
            }
        }
    }

    protected  <M extends Message> void validateNotNull(final M message, final String field){
        try {
            final Object object = FieldUtils.readField(message, field, true);
            if(object == null){
                throw new NullPointerException("The following value cannot be null in the message " + message.getClass().getSimpleName() + ": " + field);
            }
        } catch (IllegalAccessException e) {
            LOGGER.error("Unable to read the following value in the message " + message.getClass().getSimpleName() + ": " + field);
        }
    }

    /**
     * Get the current logged in user username
     * @return The username of the current logged in user
     * @see User
     */
    protected String getLoggedInUsername(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return UNKNOWN_USER;
        }
        return authentication.getName();
    }




}