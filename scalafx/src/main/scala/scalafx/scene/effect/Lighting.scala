/*
* Copyright (c) 2012-2013, ScalaFX Project
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*     * Redistributions of source code must retain the above copyright
*       notice, this list of conditions and the following disclaimer.
*     * Redistributions in binary form must reproduce the above copyright
*       notice, this list of conditions and the following disclaimer in the
*       documentation and/or other materials provided with the distribution.
*     * Neither the name of the ScalaFX Project nor the
*       names of its contributors may be used to endorse or promote products
*       derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
* ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
* FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
* DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
* AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package scalafx.scene.effect

import javafx.scene.{ effect => jfxse }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate

object Lighting {
  implicit def sfxLighting2jfx(l: Lighting) = l.delegate
}

class Lighting(override val delegate: jfxse.Lighting = new jfxse.Lighting) extends Effect(delegate) with SFXDelegate[jfxse.Lighting] {

  /**
   * Creates a new instance of Lighting with the specified light.
   */
  def this(light: Light) = this(new jfxse.Lighting(light))

  /**
   * The optional bump map input.
   */
  def bumpInput: ObjectProperty[jfxse.Effect] = delegate.bumpInputProperty
  def bumpInput_=(v: Effect) {
    bumpInput() = v
  }

  /**
   * The content input for this Effect.
   */
  def contentInput: ObjectProperty[jfxse.Effect] = delegate.contentInputProperty
  def contentInput_=(v: Effect) {
    contentInput() = v
  }

  /**
   * The diffuse constant.
   */
  def diffuseConstant: DoubleProperty = delegate.diffuseConstantProperty
  def diffuseConstant_=(v: Double) {
    diffuseConstant() = v
  }

  /**
   * The light source for this Lighting effect.
   */
  def light: ObjectProperty[jfxse.Light] = delegate.lightProperty
  def light_=(v: Light) {
    light() = v
  }

  /**
   * The specular constant.
   */
  def specularConstant: DoubleProperty = delegate.specularConstantProperty
  def specularConstant_=(v: Double) {
    specularConstant() = v
  }

  /**
   * The specular exponent.
   */
  def specularExponent: DoubleProperty = delegate.specularExponentProperty
  def specularExponent_=(v: Double) {
    specularExponent() = v
  }

  /**
   * The surface scale factor.
   */
  def surfaceScale: DoubleProperty = delegate.surfaceScaleProperty
  def surfaceScale_=(v: Double) {
    surfaceScale() = v
  }

}