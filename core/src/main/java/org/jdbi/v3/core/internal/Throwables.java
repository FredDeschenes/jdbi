/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.core.internal;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Throwables {
    private Throwables() {
        throw new UnsupportedOperationException("utility class");
    }

    /**
     * returns t directly if it is unchecked, otherwise wraps it in a RuntimeException
     */
    public static RuntimeException uncheck(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        }

        if (t instanceof IOException) {
            return new UncheckedIOException((IOException) t);
        }

        return new RuntimeException(t);
    }
}