/*
 * Copyright 2021 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.spec;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import tech.pegasys.teku.spec.constants.SpecConstants;
import tech.pegasys.teku.spec.constants.SpecConstantsBuilder;
import tech.pegasys.teku.spec.constants.SpecConstantsReader;

class AlteredSpecConstantsReader extends SpecConstantsReader {
  public SpecConstants read(
      final InputStream source, final Consumer<SpecConstantsBuilder> builderConsumer)
      throws IOException {
    final SpecConstantsBuilder constantsBuilder = readToBuilder(source);
    builderConsumer.accept(constantsBuilder);
    return constantsBuilder.build();
  }
}
