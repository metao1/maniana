/*
 * Copyright (C) 2011 The original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.zapta.apps.maniana.debug;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.zapta.apps.maniana.main.AppContext;

/** 
 * A static typed dialog for selecting debug commands. 
 * 
 * @author: Tal Dayan
 */
public class DebugDialog {

    public static final <T extends DebugCommand> void startDialog(final AppContext app, String title, 
            final T commands[], final DebugDialogListener<T> listener) {
        // Create array with command strings
        final int n = commands.length;
        final String[] commandsText = new String[n];
        for (int i = 0; i < n; i++) {
            commandsText[i] = commands[i].getText();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(app.context());
        builder.setTitle(title);
        builder.setItems(commandsText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int itemIndex) {
                final T command = commands[itemIndex];
                listener.onDebugCommand(command);
            }
        }).show();
    }
}
