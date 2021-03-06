/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
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
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.collector.client.redis;

import org.skywalking.apm.collector.client.Client;
import org.skywalking.apm.collector.client.ClientException;
import redis.clients.jedis.Jedis;

/**
 * Redis 客户端
 *
 * @author peng-yongsheng
 */
public class RedisClient implements Client {

    private Jedis jedis;

    private final String host;
    private final int port;

    public RedisClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override public void initialize() throws ClientException {
        jedis = new Jedis(host, port);
    }

    @Override public void shutdown() {

    }

    public void setex(String key, int seconds, String value) {
        jedis.setex(key, seconds, value);
    }
}
