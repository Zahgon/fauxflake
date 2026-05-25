/*
 * Copyright 2012-2014 Ray Holder
 *
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
package com.github.rholder.fauxflake.provider.boundary;

import com.github.rholder.fauxflake.api.EncodingProvider;
import java.nio.ByteBuffer;
import static com.github.rholder.fauxflake.util.StringUtils.leftPad;
import static java.lang.Long.toHexString;

/**
 * This class provides functionality for working with Flake-style unique
 * identifiers, defined as being a 128-bit unsigned long value where the first
 * 64 bits store the number of milliseconds from the epoch, the next 48 bits
 * are the machine id, and the final 16 bits are a sequence number.  The
 * beginning of time (epoch) is measured as the number of milliseconds from
 * the Unix epoch.
 * <p/>
 * See http://boundary.com/blog/2012/01/12/flake-a-decentralized-k-ordered-unique-id-generator-in-erlang/
 * for more about the Flake identifier specification developed by Boundary.
 */
public class FlakeEncodingProvider implements EncodingProvider {

    private long shiftedMachineId;

    public FlakeEncodingProvider(long machineId) {
        shiftedMachineId = (0x0000FFFFFFFFFFFFl & machineId) << 16;
    }

    /**
     * Return a 128-bit version of the given time and sequence numbers according
     * to the Flake specification.
     *
     * @param time     a time value to encode
     * @param sequence a sequence value to encode
     * @return the Flake id as bytes
     */
    @Override
    public byte[] encodeAsBytes(long time, int sequence) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This always throws an {@link UnsupportedOperationException} since the
     * output of this {@link EncodingProvider} doesn't fit in 4 bytes.
     *
     * @param time     a time value to encode
     * @param sequence a sequence value to encode
     * @return never returns
     */
    @Override
    public long encodeAsLong(long time, int sequence) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return the 32 character left padded hex version of the given id. These
     * can be lexicographically sorted.
     *
     * @param time     a time value to encode
     * @param sequence a sequence value to encode
     * @return 32 character left padded hex version of the given id
     */
    @Override
    public String encodeAsString(long time, int sequence) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int maxSequenceNumbers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
