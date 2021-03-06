package org.jetbrains.kotlin.konan.jsinterop.tool

import org.jetbrains.kotlin.konan.jsinterop.tool.Type.*

// This shall be an output of Web IDL parser.
val all = listOf(
    Interface("Context", 
        Attribute("lineWidth", Integer),
        Attribute("fillStyle", idlString),
        Attribute("strokeStyle", idlString),

        Operation("lineTo", Void, Arg("x", Integer), Arg("y", Integer)),
        Operation("moveTo", Void, Arg("x", Integer), Arg("y", Integer)),
        Operation("beginPath", Void),
        Operation("stroke", Void),
        Operation("fillRect", Void, Arg("x", Integer), Arg("y", Integer), Arg("width", Integer), Arg("height", Integer)),
        Operation("fillText", Void, Arg("test", idlString), Arg("x", Integer),  Arg("y", Integer), Arg("maxWidth", Integer)),
        Operation("fill", Void),
        Operation("closePath", Void)
    ),
    Interface("DOMRect",
        Attribute("left", Integer),
        Attribute("right", Integer),
        Attribute("top", Integer),
        Attribute("bottom", Integer)
    ),
    Interface("Canvas",
        Operation("getContext", InterfaceRef("Context"), Arg("context", idlString)),
        Operation("getBoundingClientRect", InterfaceRef("DOMRect"))
    ),
    Interface("Document",
        Operation("getElementById", Object, Arg("id", idlString))
    ),
    Interface("MouseEvent",
        Attribute("clientX", Integer, readOnly = true),
        Attribute("clientY", Integer, readOnly = true)
    ),
    Interface("Response",
        Operation("json", Object)
    ),
    Interface("Promise",
        Operation("then", InterfaceRef("Promise"), Arg("lambda", Function))
    ),
    Interface("__Global",
        Attribute("document", InterfaceRef("Document"), readOnly = true),

        Operation("fetch", InterfaceRef("Promise"), Arg("url", idlString)),
        Operation("setInterval", Void, Arg("lambda", Function), Arg("interval", Integer))
    )
)

   
