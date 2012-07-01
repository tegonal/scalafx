/*
 * Copyright (c) 2011, ScalaFX Project
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

package scalafx.scene.control

import scalafx.Includes._
import javafx.scene.{ control => jfxsc }
import javafx.{ event => jfxe }
import javafx.{ util => jfxu }
import scalafx.scene.Node
import scalafx.util.SFXDelegate
import scalafx.beans.property.ObjectProperty
import collection.JavaConversions._

object TreeView {
  implicit def sfxTreeView2jfx[T](v: TreeView[T]) = v.delegate

  /**
   * An EventType that indicates some edit event has occurred.
   */
  def editAnyEvent = jfxsc.TreeView.editAnyEvent

  /**
   * An EventType used to indicate that an edit event has just been canceled
   * within the TreeView upon which the event was fired.
   */
  def editCancelEvent = jfxsc.TreeView.editCancelEvent

  /**
   * An EventType that is used to indicate that an edit in a TreeView has been
   *  committed.
   */
  def editCommitEvent = jfxsc.TreeView.editCommitEvent

  /**
   * An EventType used to indicate that an edit event has started within the
   * TreeView upon which the event was fired.
   */
  def editStartEvent = jfxsc.TreeView.editStartEvent

  /**
   * Returns the number of levels of 'indentation' of the given TreeItem,
   * based on how many times getParent() can be recursively called.
   */
  def nodeLevel(node: TreeItem[_]) = jfxsc.TreeView.getNodeLevel(node)

  /**
   * Creates a new TreeView overriding layoutChildren method from JavaFX`s
   * TreeView.
   */
  def apply[T](layoutChildren: => Unit) = new TreeView[T](new jfxsc.TreeView[T] {
    override def layoutChildren = layoutChildren
  })

}

class TreeView[T](override val delegate: jfxsc.TreeView[T] = new jfxsc.TreeView[T])
  extends Control(delegate)
  with SFXDelegate[jfxsc.TreeView[T]] {

  /**
   * Creates a TreeView with the provided root node.
   */
  def this(rootItem: TreeItem[T]) = this(new jfxsc.TreeView[T](rootItem))

  def cellFactory = delegate.cellFactoryProperty
  def cellFactory_=(v: (TreeView[T] => jfxsc.TreeCell[T])) {
    cellFactory() = new jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]] {
      def call(tv: jfxsc.TreeView[T]): jfxsc.TreeCell[T] = {
        v(tv)
      }
    }
    /*
Description	Resource	Path	Location	Type
type mismatch;  
found   : java.lang.Object with javafx.util.Callback[javafx.scene.control.TreeView[T],javafx.scene.control.TreeItem[T]]  
required:                       javafx.util.Callback[javafx.scene.control.TreeView[T],javafx.scene.control.TreeCell[T]]	
TreeView.scala	/scalafx/src/scalafx/scene/control	line 92	Scala Problem
     */
  }

  /**
   * Specifies whether this TreeView is editable - only if the TreeView and
   * the TreeCells within it are both editable will a TreeCell be able to go
   * into their editing state.
   */
  def editable = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * A property used to represent the TreeItem currently being edited in the
   * TreeView, if editing is taking place, or -1 if no item is being edited.
   */
  def editingItem = delegate.editingItemProperty

  /**
   * The FocusModel provides the API through which it is possible to control
   * focus on zero or one rows of the TreeView.
   */
  def focusModel = delegate.focusModelProperty
  def focusModel_=(v: jfxsc.FocusModel[jfxsc.TreeItem[T]]) {
    focusModel() = v
  }

  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel = delegate.onEditCancelProperty
  def onEditCancel_=(v: (jfxsc.TreeView.EditEvent[T]) => Unit) {
    onEditCancel() = v
  }

  /**
   * This event handler will be fired when the user commits editing a cell.
   */
  def onEditCommit = delegate.onEditCommitProperty
  def onEditCommit_=(v: (jfxsc.TreeView.EditEvent[T]) => Unit) {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user starts editing a cell.
   */
  def onEditStart = delegate.onEditStartProperty
  def onEditStart_=(v: (jfxsc.TreeView.EditEvent[T]) => Unit) {
    onEditStart() = v
  }

  /**
   * Property representing the root node of the TreeView.
   */
  def root = delegate.rootProperty
  def root_=(v: TreeItem[T]) {
    root() = v
  }

  /**
   *
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: jfxsc.MultipleSelectionModel[jfxsc.TreeItem[T]]) {
    selectionModel() = v
  }

  /**
   * Property that represents whether or not the TreeView root node is visible.
   */
  def showRoot = delegate.showRootProperty
  def showRoot_=(v: Boolean) {
    showRoot() = v
  }

  /**
   * Instructs the TreeView to begin editing the given TreeItem, if the
   * TreeView is `editable`.
   */
  def edit(item: TreeItem[T]) = delegate.edit(item)

  /**
   * Returns the index position of the given TreeItem, taking into account the
   * current state of each TreeItem (i.e. whether or not it is expanded).
   */
  def row(item: TreeItem[T]) = delegate.getRow(item)

}