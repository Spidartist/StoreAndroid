package vn.edu.hust.listexamples

data class OneRow (val rowName: String, val apps: Array<OneApp>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OneRow

        if (rowName != other.rowName) return false
        if (!apps.contentEquals(other.apps)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = rowName.hashCode()
        result = 31 * result + apps.contentHashCode()
        return result
    }
}