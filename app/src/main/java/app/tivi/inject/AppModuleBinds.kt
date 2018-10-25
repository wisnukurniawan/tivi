/*
 * Copyright 2018 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi.inject

import android.app.Application
import app.tivi.AppNavigator
import app.tivi.TiviAppNavigator
import app.tivi.TiviApplication
import app.tivi.actions.ShowTasks
import app.tivi.appinitializers.AppInitializer
import app.tivi.appinitializers.EmojiInitializer
import app.tivi.appinitializers.EpoxyInitializer
import app.tivi.appinitializers.RxAndroidInitializer
import app.tivi.appinitializers.ThreeTenBpInitializer
import app.tivi.appinitializers.TimberInitializer
import app.tivi.tasks.ShowTasksImpl
import app.tivi.util.Logger
import app.tivi.util.TimberLogger
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {
    @Singleton
    @Binds
    abstract fun provideTiviActions(bind: ShowTasksImpl): ShowTasks

    @Binds
    abstract fun provideApplication(bind: TiviApplication): Application

    @Singleton
    @Named("app")
    @Binds
    abstract fun provideAppNavigator(bind: TiviAppNavigator): AppNavigator

    @Singleton
    @Binds
    abstract fun provideLogger(bind: TimberLogger): Logger

    @Binds
    @IntoSet
    abstract fun provideEmojiInitializer(bind: EmojiInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideEpoxyInitializer(bind: EpoxyInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideRxAndroidInitializer(bind: RxAndroidInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideThreeTenAbpInitializer(bind: ThreeTenBpInitializer): AppInitializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(bind: TimberInitializer): AppInitializer
}