/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.raptor;

import com.facebook.presto.spi.ConnectorSession;
import com.facebook.presto.spi.session.PropertyMetadata;
import com.google.common.collect.ImmutableList;

import javax.inject.Inject;

import java.util.List;

import static com.facebook.presto.spi.session.PropertyMetadata.stringSessionProperty;

public class RaptorSessionProperties
{
    private static final String EXTERNAL_BATCH_ID = "external_batch_id";

    private final List<PropertyMetadata<?>> sessionProperties;

    @Inject
    public RaptorSessionProperties()
    {
        sessionProperties = ImmutableList.of(
                stringSessionProperty(
                        EXTERNAL_BATCH_ID,
                        "Two-phase commit batch ID",
                        null,
                        true));
    }

    public List<PropertyMetadata<?>> getSessionProperties()
    {
        return sessionProperties;
    }

    public static String getExternalBatchId(ConnectorSession session)
    {
        return session.getProperty(EXTERNAL_BATCH_ID, String.class);
    }
}
