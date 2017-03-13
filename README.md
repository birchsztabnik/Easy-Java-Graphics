# Easy Java Graphics
A simple java game engine using LWJGL/OpenGL. 

The engine allows the developer to import .png files as sprites which can be placed around the screen. Sprites can be resized on the fly.

The frame class is based off the sprite. Frames have a render duration, so it is possible to create animations ranging from a slow blinking icon that is compried of 2 frames or a 60fps fast animation. The animation class is essentially an arraylist of frames that can be used to easy repeat a series of frames. A time keeping class keeps track of time for the animation and every other time based event.

The entity class serves as a base for game entities, complete with a sprite, animation and sprite movement function.

A simple particle system with emitter is included. Particles are colored circles with a life span, fading as time goes on. Emitters generate a specified amount of particles. 

Error messages are handled by the error enumerator.

Sound effects are also possible. The source needs to be specified for import and it can be played on command.
