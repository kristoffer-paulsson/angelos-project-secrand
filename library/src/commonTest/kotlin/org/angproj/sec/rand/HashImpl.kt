/**
 * Copyright (c) 2025 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */
package org.angproj.sec.rand


interface Hash : Sponge {
     fun digest(): ByteArray {
        val digestBytes = ByteArray(visibleSize * 8)
        var pos = 0
        repeat(visibleSize) {
            var state = squeeze(it)
            repeat(8) {
                digestBytes[pos++] = (state and 0xff).toByte()
                state = (state ushr 8)
            }
        }
        return digestBytes
    }
}