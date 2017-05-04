/*
 *  Copyright 2016 http://www.hswebframework.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package org.hswebframework.web.message;

import java.util.function.Consumer;

/**
 * TODO 完成注释
 *
 * @author zhouhao
 */
public abstract class SimpleMessagePublish implements MessagePublish {
    MessageSubject from;

    MessageSubject to;

    @Override
    public MessagePublish from(MessageSubject subject) {
        this.from = subject;
        return this;
    }

    @Override
    public MessagePublish to(MessageSubject subject) {
        this.to = subject;

        return this;
    }

    @Override
    public MessagePublish deleteOnTimeout(long timeOutSecond) {
        //not support now
        return this;
    }

    @Override
    public <T> void send(Consumer<T> responseConsumer) {
        responseConsumer.accept(send());
    }
}
