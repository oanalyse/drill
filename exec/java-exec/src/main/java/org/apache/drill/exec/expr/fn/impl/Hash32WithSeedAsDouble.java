/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.exec.expr.fn.impl;

import org.apache.drill.exec.expr.DrillSimpleFunc;
import org.apache.drill.exec.expr.annotations.FunctionTemplate;
import org.apache.drill.exec.expr.annotations.FunctionTemplate.FunctionScope;
import org.apache.drill.exec.expr.annotations.Output;
import org.apache.drill.exec.expr.annotations.Param;
import org.apache.drill.exec.expr.holders.BigIntHolder;
import org.apache.drill.exec.expr.holders.VarDecimalHolder;
import org.apache.drill.exec.expr.holders.NullableVarDecimalHolder;
import org.apache.drill.exec.expr.holders.Float4Holder;
import org.apache.drill.exec.expr.holders.Float8Holder;
import org.apache.drill.exec.expr.holders.IntHolder;
import org.apache.drill.exec.expr.holders.NullableBigIntHolder;
import org.apache.drill.exec.expr.holders.NullableFloat4Holder;
import org.apache.drill.exec.expr.holders.NullableFloat8Holder;
import org.apache.drill.exec.expr.holders.NullableIntHolder;

/**
 * hash32 with seed function definitions for numeric data types. These functions cast the input numeric value to a
 * double before doing the hashing. See comments in {@link Hash64AsDouble} for the reason for doing this.
 */
@SuppressWarnings("unused")
public class Hash32WithSeedAsDouble {
  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL )
  public static class NullableFloatHash implements DrillSimpleFunc {

    @Param NullableFloat4Holder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      if (in.isSet == 0) {
        out.value = seed.value;
      } else {
        out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32((double) in.value, seed.value);
      }
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL )
  public static class FloatHash implements DrillSimpleFunc {

    @Param Float4Holder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32((double) in.value, seed.value);
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL )
  public static class NullableDoubleHash implements DrillSimpleFunc {

    @Param NullableFloat8Holder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      if (in.isSet == 0) {
        out.value = seed.value;
      } else {
        out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32(in.value, seed.value);
      }
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL )
  public static class DoubleHash implements DrillSimpleFunc {

    @Param Float8Holder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32(in.value, seed.value);
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL)
  public static class NullableBigIntHash implements DrillSimpleFunc {

    @Param NullableBigIntHolder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      if (in.isSet == 0) {
        out.value = seed.value;
      }
      else {
        out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32((double) in.value, seed.value);
      }
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL)
  public static class NullableIntHash implements DrillSimpleFunc {
    @Param NullableIntHolder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      if (in.isSet == 0) {
        out.value = seed.value;
      }
      else {
        out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32((double) in.value, seed.value);
      }
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL)
  public static class BigIntHash implements DrillSimpleFunc {

    @Param BigIntHolder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32((double) in.value, seed.value);
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL)
  public static class IntHash implements DrillSimpleFunc {
    @Param IntHolder in;
    @Param IntHolder seed;
    @Output IntHolder out;


    public void setup() {
    }

    public void eval() {
      // TODO: implement hash function for other types
      out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32((double) in.value, seed.value);
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL)
  public static class VarDecimalHash implements DrillSimpleFunc {
    @Param VarDecimalHolder in;
    @Param IntHolder seed;
    @Output IntHolder out;

    public void setup() {
    }

    public void eval() {
      java.math.BigDecimal bd = org.apache.drill.exec.util.DecimalUtility.getBigDecimalFromDrillBuf(in.buffer,
              in.start, in.end - in.start, in.scale);
      out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32(bd.doubleValue(), seed.value);
    }
  }

  @FunctionTemplate(name = "hash32AsDouble", scope = FunctionScope.SIMPLE, nulls = FunctionTemplate.NullHandling.INTERNAL)
  public static class NullableVarDecimalHash implements DrillSimpleFunc {
    @Param  NullableVarDecimalHolder in;
    @Param IntHolder seed;
    @Output IntHolder out;

    public void setup() {
    }

    public void eval() {
      if (in.isSet == 0) {
        out.value = seed.value;
      } else {
        java.math.BigDecimal bd = org.apache.drill.exec.util.DecimalUtility.getBigDecimalFromDrillBuf(in.buffer,
                in.start, in.end - in.start, in.scale);
        out.value = org.apache.drill.exec.expr.fn.impl.HashHelper.hash32(bd.doubleValue(), seed.value);
      }
    }
  }
}

