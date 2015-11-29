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

package com.fortmocks.core.basis.model.user.service.message.input;

import com.fortmocks.core.basis.model.Input;
import com.fortmocks.core.basis.model.validation.NotNull;

/**
 * Deletes a user
 * @author Karl Dahlgren
 * @since 1.0
 * @see com.fortmocks.core.basis.model.user.service.message.output.DeleteUserOutput
 */
public class DeleteUserInput implements Input{

    @NotNull
    private Long userId;

    public DeleteUserInput(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
