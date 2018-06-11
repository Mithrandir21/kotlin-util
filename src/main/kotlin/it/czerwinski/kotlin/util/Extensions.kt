/*
 *
 * This Kotlin code is based on Scala, licensed under the BSD 3-Clause License.
 *
 * ===== SCALA LICENSE =====
 *
 * Copyright (c) 2002-2018 EPFL
 * Copyright (c) 2011-2018 Lightbend, Inc.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   * Neither the name of the EPFL nor the names of its contributors
 *     may be used to endorse or promote products derived from this software
 *     without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package it.czerwinski.kotlin.util

/**
 * Extracts an [Option] nested in the [Try] to a not nested [Option].
 *
 * @return [Option] nested in a [Success] or [None] if this is a [Failure].
 */
fun <T> Try<Option<T>>.flatten(): Option<T> = when (this) {
    is Success -> value
    is Failure -> None
}

/**
 * Returns [Some] if this [Some] contains a [Success]. Otherwise returns [None].
 *
 * @return [Some] if this [Some] contains a [Success]. Otherwise returns [None].
 */
fun <T> Option<Try<T>>.flatten(): Option<T> =
    if (isEmpty) None else get().toOption()

/**
 * Returns nested [List] if this is [Some]. Otherwise returns an empty [List].
 *
 * @return Nested [List] if this is [Some]. Otherwise returns an empty [List].
 */
fun <T> Option<Iterable<T>>.flatten(): List<T> =
    if (isEmpty) emptyList() else get().toList()

/**
 * Returns [List] of values of each [Some] in this [Iterable].
 *
 * @return [List] of values of each [Some] in this [Iterable].
 */
fun <T> Iterable<Option<T>>.flatten(): List<T> =
    flatMap { it.toList() }
