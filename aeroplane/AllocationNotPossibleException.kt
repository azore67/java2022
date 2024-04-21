package aeroplane

import java.io.Serializable

class AllocationNotPossibleException : Exception {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)

    companion object {
        @JvmStatic
        private val serialVersionUID = 1L
    }
}
