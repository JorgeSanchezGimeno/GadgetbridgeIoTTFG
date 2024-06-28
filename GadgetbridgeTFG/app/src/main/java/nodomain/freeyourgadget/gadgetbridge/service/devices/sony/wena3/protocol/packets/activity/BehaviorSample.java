/*
 *   Copyright (C) 2023 akasaka / Genjitsu Labs
 *
 *     This file is part of Gadgetbridge.
 *
 *     Gadgetbridge is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Gadgetbridge is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nodomain.freeyourgadget.gadgetbridge.service.devices.sony.wena3.protocol.packets.activity;

import java.util.Date;

public class BehaviorSample {
    public enum Type {
        UNKNOWN,
        NOT_WEARING,
        WALK,
        RUN,
        EXERCISE,
        SLEEP_DEEP,
        SLEEP_LIGHT,
        SLEEP_REM,
        SLEEP_AWAKE,
        STATIC;

        public final static Type[] LUT = new Type[] {
                UNKNOWN,
                NOT_WEARING,
                WALK,
                RUN,
                EXERCISE,
                SLEEP_DEEP,
                SLEEP_LIGHT,
                SLEEP_REM,
                SLEEP_AWAKE,
                STATIC
        };
    }

    public final Date start;
    public final Date end;
    public final Type type;

    public BehaviorSample(Date start, Date end, Type type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }
}