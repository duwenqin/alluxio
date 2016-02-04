/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package alluxio.hadoop;

import javax.annotation.concurrent.NotThreadSafe;

import alluxio.Constants;

/**
 * A Tachyon client API compatible with Apache Hadoop {@link org.apache.hadoop.fs.FileSystem}
 * interface. Any program working with Hadoop HDFS can work with Tachyon transparently. Note that
 * the performance of using this fault tolerant API may not be as efficient as the performance of
 * using the Tachyon native API defined in {@link alluxio.client.file.FileSystem}, which the API is
 * built on top of.
 *
 * <p>
 * Unlike {@link FileSystem}, this class enables Zookeeper.
 * </p>
 */
@NotThreadSafe
public final class FaultTolerantFileSystem extends AbstractFileSystem {

  @Override
  public String getScheme() {
    return Constants.SCHEME_FT;
  }

  @Override
  protected boolean isZookeeperMode() {
    return true;
  }
}